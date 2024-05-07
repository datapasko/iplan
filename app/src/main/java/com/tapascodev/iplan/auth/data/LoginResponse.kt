package com.tapascodev.iplan.auth.data

import com.google.gson.annotations.SerializedName
import com.tapascodev.iplan.auth.domain.LoginResponseModel

data class LoginResponse (
    @SerializedName("employee_id") val id: Int,
    @SerializedName("email") val email: String?,
    @SerializedName("token") val token: String,
    @SerializedName("completed_name") val name: String,
    @SerializedName("office_name") val office: String?,
) {
    fun toDomain(): LoginResponseModel {
        return LoginResponseModel( id, email, token, name, office )
    }
}