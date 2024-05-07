package com.tapascodev.iplan.employee.ui

import com.tapascodev.iplan.employee.domain.Employee
import com.tapascodev.iplan.employee.domain.EmployeeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EmployeeViewModel (
    private val repository: EmployeeRepository
) {


    private var _employees = MutableStateFlow<List<Employee>>(emptyList())
    val employees: StateFlow<List<Employee>> = _employees


}