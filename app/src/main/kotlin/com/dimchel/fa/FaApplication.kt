package com.dimchel.fa

import android.app.Application
import com.dimchel.fa.feature.league.api.LeagueFeatureProvider
import com.dimchel.fa.feature.league.api.di.LeagueDepsProvider
import com.dimchel.fa.feature.league.impl.di.LeagueDepsProviderImpl
import com.google.android.material.color.DynamicColors

class FaApplication: Application(), LeagueFeatureProvider {

    override fun onCreate() {
        super.onCreate()

        DynamicColors.applyToActivitiesIfAvailable(this)
    }

    override fun getLeagueDepsProvider(): LeagueDepsProvider = LeagueDepsProviderImpl
}