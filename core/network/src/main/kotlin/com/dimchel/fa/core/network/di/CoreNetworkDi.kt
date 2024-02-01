package com.dimchel.fa.core.network.di

import android.app.Application
import com.dimchel.fa.core.common.di.AppScope
import com.dimchel.fa.core.network.BASE_URL
import com.dimchel.fa.core.network.JSON_CONTENT_TYPE
import com.dimchel.fa.core.network.SESSION_HEADER
import com.dimchel.fa.core.network.SESSION_TOKEN
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit

@AppScope
@Component(modules = [NetworkModule::class])
internal interface CoreNetworkComponent : CoreNetworkDependency {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
        ): CoreNetworkComponent
    }
}

@Module
internal class NetworkModule {

    companion object {
        @AppScope
        @Provides
        fun provideOkHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

        @AppScope
        @Provides
        fun provideOkHttpInterceptor(): Interceptor =
            Interceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader(SESSION_HEADER, SESSION_TOKEN)
                    .build()

                chain.proceed(request)
            }

        @AppScope
        @Provides
        fun provideOkHttpClient(
            headerInterceptor: Interceptor,
            loggingInterceptor: HttpLoggingInterceptor
        ): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()


        @AppScope
        @Provides
        fun provideJson(): Json = Json{ ignoreUnknownKeys = true }

        @AppScope
        @Provides
        fun provideConverterFactory(json : Json): Converter.Factory =
            json.asConverterFactory(JSON_CONTENT_TYPE)

        @AppScope
        @Provides
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            converterFactory: Converter.Factory,
        ): Retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .baseUrl(BASE_URL)
                .build()
    }
}
