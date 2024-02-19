package com.dimchel.fa.league.data.api

import com.dimchel.fa.league.data.schemes.LeagueScheme
import retrofit2.http.GET
import retrofit2.http.Path

internal interface LeagueApiService {

    @GET("v4/competitions/{code}/standings")
    suspend fun getLeague(@Path("code") leagueCode: String): LeagueScheme

}