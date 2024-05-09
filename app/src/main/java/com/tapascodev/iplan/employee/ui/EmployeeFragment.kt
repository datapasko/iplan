package com.tapascodev.iplan.employee.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tapascodev.iplan.base.ui.BaseFragment
import com.tapascodev.iplan.base.ui.handleApiError
import com.tapascodev.iplan.base.ui.visible
import com.tapascodev.iplan.databinding.FragmentEmployeeBinding
import com.tapascodev.iplan.employee.adapter.EmployeeAdapter
import com.tapascodev.iplan.network.data.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EmployeeFragment : BaseFragment<FragmentEmployeeBinding> (
    FragmentEmployeeBinding::inflate
){

    private lateinit var employeeAdapter: EmployeeAdapter

    private val viewModel by viewModels<EmployeeViewModel> ()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getEmployees()
        initUI()
        filterRecyclerView()
    }

    private fun initUI() {
        initRecyclerView()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.employees.collect{
                    binding.pbEmployee.visible( it is Resource.Loading)
                    when(it) {
                        is Resource.Success -> { employeeAdapter.updatedList(it.value) }
                        is Resource.Failure -> handleApiError(it)
                        is Resource.Loading -> { binding.pbEmployee.visible(true ) }
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        employeeAdapter = EmployeeAdapter()
        binding.rvEmployee.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = employeeAdapter
        }
    }

    private fun filterRecyclerView() {
        binding.svEmployee.setOnQueryTextListener(object:  SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean { return false }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    lifecycleScope.launch {
                        viewModel.employees.collect{ resource ->
                            when(resource) {
                                is Resource.Success -> {
                                    val filtered = resource.value.filter { employee ->
                                        newText.let { query ->
                                            employee.email.lowercase().contains(query.lowercase())
                                                    || employee.name.lowercase().contains(query.lowercase())
                                        }
                                    }
                                    employeeAdapter.updatedList(filtered)
                                }
                                is Resource.Failure -> {  }
                                is Resource.Loading -> {  }
                            }
                        }
                    }
                }
                return true
            }
        })
    }
}