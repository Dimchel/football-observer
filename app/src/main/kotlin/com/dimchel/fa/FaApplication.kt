package com.dimchel.fa

import android.app.Application
import com.google.android.material.color.DynamicColors

internal class FaApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}