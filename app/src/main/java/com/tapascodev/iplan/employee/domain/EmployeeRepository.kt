package com.tapascodev.iplan.employee.domain

import com.tapascodev.iplan.base.domain.BaseRepository
import com.tapascodev.iplan.employee.data.EmployeeApi
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val api: EmployeeApi
) : BaseRepository(api) {

    suspend fun getEmployees() = safeApiCall { api.employees().map { it.toDomain() } }
}