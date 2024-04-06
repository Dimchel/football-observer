package com.dimchel.fa.feature.league.impl.di

import com.dimchel.fa.core.common.di.FeatureScope
import com.dimchel.fa.feature.league.api.presentation.LeagueScreenStartParams
import javax.inject.Inject

@FeatureScope
internal class StartParamsHolder @Inject constructor() {
    lateinit var leagueStartParams: LeagueScreenStartParams
}