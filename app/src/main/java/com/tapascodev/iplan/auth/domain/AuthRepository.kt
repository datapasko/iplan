package com.tapascodev.iplan.auth.domain

import com.tapascodev.iplan.auth.data.AuthApi
import com.tapascodev.iplan.base.domain.BaseRepository
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: AuthApi
) : BaseRepository(api) {

    suspend fun login(
        email:String,
        password: String
    ) = safeApiCall {
        api.login(email, password).toDomain()
    }
}