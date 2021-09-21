package com.anderson.crewchat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment<VM: BaseViewModel, VB: ViewBinding>(resId: Int): Fragment(resId) {
    protected abstract var binding: VB
    protected abstract val viewModel: VM
    protected abstract fun initEvents()
    protected abstract fun initViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initEvents()
        initViewModels()
        super.onViewCreated(view, savedInstanceState)
    }


}