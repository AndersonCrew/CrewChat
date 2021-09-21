package com.anderson.crewchat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.anderson.crewchat.BaseFragment
import com.anderson.crewchat.R
import com.anderson.crewchat.databinding.FragmentLoginBinding
import com.anderson.crewchat.viewmodel.LoginViewModel

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(R.layout.fragment_login) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override lateinit var binding: FragmentLoginBinding
    override val viewModel by viewModels<LoginViewModel>()

    override fun initEvents() {

    }

    override fun initViewModels() {

    }
}