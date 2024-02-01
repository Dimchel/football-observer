package com.dimchel.fa.feature.leagues.ui

import com.dimchel.fa.core.ui.BaseFragment
import com.dimchel.fa.feature.leagues.R
import com.dimchel.fa.feature.leagues.di.LeaguesDependencyProvider

internal class LeaguesFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_leagues

    override fun injectDependencies() {
        LeaguesDependencyProvider.provide(requireActivity().application)
    }
}