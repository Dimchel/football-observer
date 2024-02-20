package com.dimchel.fa.feature.competitions.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.dimchel.fa.core.architecture.BaseFragment
import com.dimchel.fa.feature.competitions.di.CompetitionsDependencyProvider
import javax.inject.Inject
import javax.inject.Provider

internal class CompetitionsFragment : BaseFragment() {

    companion object {
        fun newInstance(): CompetitionsFragment = CompetitionsFragment()
    }

    @Inject
    internal lateinit var viewModelProvider: Provider<CompetitionsViewModel>
    private val viewModel: CompetitionsViewModel by lazy { viewModelProvider.get() }

    override fun injectDependencies() =
        CompetitionsDependencyProvider.provide(requireActivity().application).inject(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = ComposeView(requireContext()).apply {
        setContent {
            CompetitionsScreen(viewModel) { leagueId ->
                viewModel.onLeagueClicked(leagueId)
            }
        }
    }
}