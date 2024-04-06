package com.dimchel.fa.feature.competitions.api

import com.dimchel.fa.core.common.di.DepsProvider
import com.dimchel.fa.core.common.di.OutDeps

interface CompetitionsOutDeps: OutDeps {
    fun getCompetitionsScreenProvider(): CompetitionsScreenProvider
}

interface CompetitionsDepsProvider : DepsProvider<CompetitionsOutDeps>