package com.tapascodev.iplan.base.domain

import com.tapascodev.iplan.base.data.BaseApi
import com.tapascodev.iplan.network.data.SafeApiCall

abstract class BaseRepository(private val api: BaseApi) : SafeApiCall {
    suspend fun logout() = safeApiCall {
        api.logout()
    }
}