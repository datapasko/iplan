package com.tapascodev.iplan.employee.domain

data class Employee (
    val id: Int,
    val name: String,
    val email: String,
    val number: String,
    val extension: String?,
    val department: String?,
    val office: String?,
)