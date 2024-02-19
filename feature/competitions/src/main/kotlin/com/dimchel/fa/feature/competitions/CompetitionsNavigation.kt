package com.dimchel.fa.feature.competitions

import androidx.fragment.app.Fragment
import com.dimchel.fa.feature.competitions.ui.CompetitionsFragment

object CompetitionsNavigation {
    fun getScreen() : Fragment = CompetitionsFragment.newInstance()
}