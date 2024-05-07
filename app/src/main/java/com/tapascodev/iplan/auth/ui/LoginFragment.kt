package com.tapascodev.iplan.auth.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.tapascodev.iplan.R
import com.tapascodev.iplan.auth.data.AuthApi
import com.tapascodev.iplan.auth.domain.AuthRepository
import com.tapascodev.iplan.auth.domain.LoginResponseModel
import com.tapascodev.iplan.base.ui.BaseFragment
import com.tapascodev.iplan.base.ui.handleApiError
import com.tapascodev.iplan.base.ui.visible
import com.tapascodev.iplan.databinding.FragmentLoginBinding
import com.tapascodev.iplan.network.data.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUI()

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.pbLogin.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> saveToken(it.value)
                is Resource.Failure -> handleApiError(it) { login() }
                else -> {}
            }
        })
    }

    private fun saveToken(responseModel: LoginResponseModel) {
        Log.d("barcelona", responseModel.toString())

    }

    private fun initUI() {

        binding.apply {
            pbLogin.visible(false)
            btnLogin.setOnClickListener{
                login()
            }
        }
    }

    private fun login() {
        val email = binding.inputEmail.editText?.text?.toString()!!.trim()
        val password = binding.inputPassword.editText?.text?.toString()!!.trim()
        viewModel.login(email, password)
    }
}