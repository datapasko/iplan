package com.tapascodev.iplan.employee.data

import com.google.gson.annotations.SerializedName
import com.tapascodev.iplan.employee.domain.Employee

data class EmployeeResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("completed_name") val name: String,
    @SerializedName("user_email") val email: String,
    @SerializedName("number_line") val number: String,
    @SerializedName("extension_line") val extension: String?,
    @SerializedName("department_name") val department: String?,
    @SerializedName("office_name") val office: String?,
) {
    fun toDomain(): Employee {
        return Employee(
            id,
            name,
            email,
            number,
            extension,
            department,
            office
        )
    }
}