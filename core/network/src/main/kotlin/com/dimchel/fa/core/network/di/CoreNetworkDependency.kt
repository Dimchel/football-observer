package com.dimchel.fa.core.network.di

import retrofit2.Retrofit

interface CoreNetworkDependency {
    fun provideRetrofit(): Retrofit
}