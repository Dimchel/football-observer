package com.dimchel.fa.feature.leagues

import androidx.fragment.app.Fragment
import com.dimchel.fa.feature.leagues.ui.LeaguesFragment

object LeaguesNavigation {
    fun getScreen() : Fragment = LeaguesFragment.newInstance()
}