package com.example.firstmvvm.ui.home.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.firstmvvm.R
import com.example.firstmvvm.databinding.FragmentProfileBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ProfileFragment : Fragment(), KodeinAware {

    private lateinit var viewModel: ProfileViewModel
    override val kodein by kodein()
    private val factory: ProfileViewModelFactory by instance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProfileBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        viewModel = ViewModelProvider(this, factory)[ProfileViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}