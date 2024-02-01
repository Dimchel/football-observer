package com.dimchel.fa.feature.leagues.data.api

import com.dimchel.fa.feature.leagues.data.schemes.LeaguesScheme
import retrofit2.http.GET

internal interface LeaguesApiService {

    @GET("v2/competitions")
    suspend fun getLeaguesList(): LeaguesScheme

}