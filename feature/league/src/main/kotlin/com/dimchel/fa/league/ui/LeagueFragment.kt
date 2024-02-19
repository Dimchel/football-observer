package com.dimchel.fa.league.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.dimchel.fa.core.architecture.BaseFragment
import com.dimchel.fa.league.di.LeagueDependencyProvider
import javax.inject.Inject
import javax.inject.Provider

internal class LeagueFragment : BaseFragment() {

    companion object {
        fun newInstance(): LeagueFragment = LeagueFragment()
    }

    @Inject
    internal lateinit var viewModelProvider: Provider<LeagueViewModel>
    private val viewModel: LeagueViewModel by lazy { viewModelProvider.get() }

    override fun injectDependencies() =
        LeagueDependencyProvider.provide(requireActivity().application).inject(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = ComposeView(requireContext()).apply {
        setContent {
            LeaguesScreen(viewModel) { leagueId ->
                viewModel.onLeagueClicked(leagueId)
            }
        }
    }
}