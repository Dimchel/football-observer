package com.dimchel.fa.core.network.di

import com.dimchel.fa.core.common.di.Dependencies
import retrofit2.Retrofit

interface CoreNetworkDependency : Dependencies {
    fun provideRetrofit(): Retrofit
}