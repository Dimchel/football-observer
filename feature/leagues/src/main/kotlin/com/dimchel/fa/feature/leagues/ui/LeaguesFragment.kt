package com.dimchel.fa.feature.leagues.ui

import android.os.Bundle
import android.view.View
import com.dimchel.fa.core.common.utils.klog
import com.dimchel.fa.core.ui.BaseFragment
import com.dimchel.fa.feature.leagues.R
import com.dimchel.fa.feature.leagues.data.repositories.LeaguesRepository
import com.dimchel.fa.feature.leagues.di.LeaguesDependencyProvider
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

internal class LeaguesFragment : BaseFragment() {

    companion object {
        fun newInstance(): LeaguesFragment = LeaguesFragment()
    }

    @Inject
    lateinit var repository: LeaguesRepository

    override fun getLayoutResId(): Int = R.layout.fragment_leagues

    override fun injectDependencies() {
        LeaguesDependencyProvider.provide(requireActivity().application).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        runBlocking {
            klog("result: " + repository.getLeagues().toString())
        }
    }
}