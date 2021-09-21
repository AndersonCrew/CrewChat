package com.anderson.crewchat.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.anderson.crewchat.BaseFragment
import com.anderson.crewchat.R
import com.anderson.crewchat.databinding.FragmentSplashBinding
import com.anderson.crewchat.utils.SharePreferenceUtil
import com.anderson.crewchat.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {

    @Inject lateinit var mPref: SharePreferenceUtil
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override var binding: FragmentSplashBinding?= null
    override val viewModel by viewModels<SplashViewModel>()
    override fun initEvents() {
        val mainScope = CoroutineScope(Dispatchers.Main)
        binding?.btnClick?.setOnClickListener {
            mainScope.launch {

                val job1 = launch {
                    mPref.putStringExtra("ABC", binding?.etStr?.text.toString())
                    delay(3000L)
                    Log.d("ABC", "Job1 done")
                }

                val job2 = launch {
                    job1.join()
                    binding?.tvStr?.text = mPref.getStringExtra("ABC", "Cannot get data from SharePreference")
                    Log.d("ABC", "Job2 done")
                }
            }


        }
    }

    override fun initViewModels() {

    }

}