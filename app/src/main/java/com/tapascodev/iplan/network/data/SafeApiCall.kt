package com.tapascodev.iplan.network.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ) : Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when(throwable) {
                    is HttpException ->{
                        Resource.Failure(
                            false,
                            throwable.hashCode(),
                            throwable.response()?.errorBody()
                        )
                    }

                    else -> {
                        Resource.Failure(
                            true,
                            null,
                            null
                        )
                    }
                }
            }
        }
    }
}