package com.tapascodev.iplan.employee.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tapascodev.iplan.databinding.ItemEmployeeBinding
import com.tapascodev.iplan.employee.domain.Employee

class EmployeeViewHolder(
    view:View
): RecyclerView.ViewHolder(view) {

    private  val binding = ItemEmployeeBinding.bind(view)

    fun render (employee: Employee) {
        binding.apply {
            tvName.text = employee.name
            tvEmail.text = employee.email
            tvPhone.text = employee.phone

            ivPhone.setOnClickListener {
                //call
            }

            ivEmail.setOnClickListener {
                //email
            }
        }
    }
}