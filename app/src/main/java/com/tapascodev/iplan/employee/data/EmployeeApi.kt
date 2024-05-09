package com.tapascodev.iplan.employee.data

import com.tapascodev.iplan.base.data.BaseApi
import retrofit2.http.GET

interface EmployeeApi: BaseApi {

    @GET("employees-directory")
    suspend fun employees(): List<EmployeeResponse>
}