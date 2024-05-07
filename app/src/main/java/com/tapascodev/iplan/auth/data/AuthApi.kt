package com.tapascodev.iplan.auth.data

import com.tapascodev.iplan.base.data.BaseApi
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi: BaseApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun login (
        @Field("email") email:String,
        @Field("password") password: String,
    ) : LoginResponse
}