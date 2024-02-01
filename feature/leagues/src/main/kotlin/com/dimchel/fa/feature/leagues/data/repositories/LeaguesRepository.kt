package com.dimchel.fa.feature.leagues.data.repositories

import com.dimchel.fa.feature.leagues.data.schemes.LeaguesScheme

internal interface LeaguesRepository {

    suspend fun getLeagues() : LeaguesScheme

}