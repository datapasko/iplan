package com.tapascodev.iplan.auth.data

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.tapascodev.iplan.auth.ui.AuthActivity
import com.tapascodev.iplan.base.ui.startNewActivity
import com.tapascodev.iplan.home.ui.HomeActivity
import com.tapascodev.iplan.storage.data.UserPreferences
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
            .newBuilder()
            .header("Authorization", "Bearer ${tokenManager.getToken()}")
            .build()

        return chain.proceed(request)
    }
}

class TokenManager @Inject constructor() {
    fun getToken() : String = "token"
}