package com.tapascodev.iplan.employee.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tapascodev.iplan.R
import com.tapascodev.iplan.employee.domain.Employee

class EmployeeAdapter (
    private var employeeList: List<Employee> = emptyList()
) : RecyclerView.Adapter<EmployeeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        )
    }

    override fun getItemCount() = employeeList.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.render(employeeList[position])
    }
}