package com.dimchel.fa.core.network.di

import com.dimchel.fa.core.common.di.OutDeps
import retrofit2.Retrofit

interface CoreNetworkDependency : OutDeps {
    fun provideRetrofit(): Retrofit
}