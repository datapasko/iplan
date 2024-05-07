package com.tapascodev.iplan.auth.domain

data class LoginResponseModel(
    val id: Int,
    val email: String?,
    val token: String,
    val name: String,
    val office: String?,
)
