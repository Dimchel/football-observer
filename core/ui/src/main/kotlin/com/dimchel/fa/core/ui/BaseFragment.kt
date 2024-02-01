package com.dimchel.fa.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    protected abstract fun injectDependencies()
    protected open fun releaseDependencies() = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(getLayoutResId(), container, false)

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