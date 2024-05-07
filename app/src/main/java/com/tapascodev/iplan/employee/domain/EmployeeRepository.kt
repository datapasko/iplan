package com.tapascodev.iplan.employee.domain

import com.tapascodev.iplan.base.domain.BaseRepository
import com.tapascodev.iplan.employee.data.EmployeeApi

class EmployeeRepository (
    private val api: EmployeeApi
) : BaseRepository(api) {

    //suspend fun getEmployees() = safeApiCall { api.getEmployees() }
}