package com.tapascodev.iplan.auth.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tapascodev.iplan.auth.domain.AuthRepository
import com.tapascodev.iplan.auth.domain.LoginResponseModel
import com.tapascodev.iplan.base.ui.BaseViewModel
import com.tapascodev.iplan.network.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
): BaseViewModel(repository) {

    private val _loginResponse: MutableLiveData<Resource<LoginResponseModel>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponseModel>>
        get() = _loginResponse

    fun login(email: String, password: String)  = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = repository.login(email, password)
    }


}