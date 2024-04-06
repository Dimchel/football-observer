package com.dimchel.fa.feature.competitions.impl.data.datasources

import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.core.network.safeApiCall
import com.dimchel.fa.feature.competitions.impl.data.schemes.CompetitionsScheme
import com.dimchel.fa.feature.competitions.impl.data.api.CompetitionsApiService
import javax.inject.Inject

internal class CompetitionsNetworkDataSource @Inject constructor(
    private val apiService: CompetitionsApiService
) {
    internal suspend fun getCompetitionsList(): DataResult<CompetitionsScheme> =
        safeApiCall { apiService.getCompetitionsList() }
}