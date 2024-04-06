package com.dimchel.fa.feature.competitions.impl.data.api

import com.dimchel.fa.feature.competitions.impl.data.schemes.CompetitionsScheme
import retrofit2.http.GET

internal interface CompetitionsApiService {

    @GET("v4/competitions")
    suspend fun getCompetitionsList(): CompetitionsScheme

}