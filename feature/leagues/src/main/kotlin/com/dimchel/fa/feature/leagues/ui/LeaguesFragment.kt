package com.dimchel.fa.feature.leagues.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.viewModelScope
import com.dimchel.fa.core.ui.BaseFragment
import com.dimchel.fa.feature.leagues.di.LeaguesDependencyProvider
import javax.inject.Inject
import javax.inject.Provider

internal class LeaguesFragment : BaseFragment() {

    companion object {
        fun newInstance(): LeaguesFragment = LeaguesFragment()
    }

    @Inject
    internal lateinit var viewModelProvider: Provider<LeaguesViewModel>
    private val viewModel: LeaguesViewModel by lazy { viewModelProvider.get() }

    override fun injectDependencies() =
        LeaguesDependencyProvider.provide(requireActivity().application).inject(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = ComposeView(requireContext()).apply {
        setContent {
            LeaguesScreen()
        }
        viewModel.viewModelScope
    }
}