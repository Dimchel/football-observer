package com.dimchel.fa.feature.competitions.data.datasources

import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.core.network.safeApiCall
import com.dimchel.fa.feature.competitions.data.api.CompetitionsApiService
import com.dimchel.fa.feature.competitions.data.schemes.CompetitionsScheme
import javax.inject.Inject

internal class CompetitionsNetworkDataSource @Inject constructor(
    private val apiService: CompetitionsApiService
) {
    internal suspend fun getCompetitionsList(): DataResult<CompetitionsScheme> =
        safeApiCall { apiService.getCompetitionsList() }
}