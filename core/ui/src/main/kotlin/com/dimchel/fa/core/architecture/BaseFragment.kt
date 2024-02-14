package com.dimchel.fa.core.architecture

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    protected abstract fun injectDependencies()
    protected open fun releaseDependencies() = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()

        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        if (isFragmentRemoving(this)) {
            releaseDependencies()
        }

        super.onDestroy()
    }

    private fun isFragmentRemoving(fragment: Fragment): Boolean {
        val isActivityFinishing = fragment.activity?.isFinishing ?: false

        return isActivityFinishing || fragment.isRemoving
    }
}