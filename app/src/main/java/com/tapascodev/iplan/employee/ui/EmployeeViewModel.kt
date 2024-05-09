package com.tapascodev.iplan.employee.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tapascodev.iplan.base.ui.BaseViewModel
import com.tapascodev.iplan.employee.domain.Employee
import com.tapascodev.iplan.employee.domain.EmployeeRepository
import com.tapascodev.iplan.network.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor (
    private val repository: EmployeeRepository
): BaseViewModel(repository) {

    private var _employees = MutableStateFlow<Resource<List<Employee>>>(Resource.Loading)
    val employees: StateFlow<Resource<List<Employee>>> = _employees

    fun getEmployees() {
        viewModelScope.launch {
            _employees.value = Resource.Loading
            _employees.value = repository.getEmployees()
        }
    }

    fun filter(query: String) {

    }


}