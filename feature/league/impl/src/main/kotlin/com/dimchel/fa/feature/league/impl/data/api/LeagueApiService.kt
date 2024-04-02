package com.dimchel.fa.feature.league.impl.data.api

import com.dimchel.fa.feature.league.impl.data.schemes.LeagueScheme
import retrofit2.http.GET
import retrofit2.http.Path

internal interface LeagueApiService {

    @GET("v4/competitions/{code}/standings")
    suspend fun getLeague(@Path("code") leagueCode: String): LeagueScheme

}