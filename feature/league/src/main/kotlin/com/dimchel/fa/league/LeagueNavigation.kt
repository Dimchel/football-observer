package com.dimchel.fa.league

import androidx.fragment.app.Fragment
import com.dimchel.fa.league.presentation.LeagueFragment

object LeagueNavigation {
    fun getScreen() : Fragment = LeagueFragment.newInstance()
}