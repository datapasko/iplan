package com.tapascodev.iplan.employee.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tapascodev.iplan.R
import com.tapascodev.iplan.base.ui.BaseFragment
import com.tapascodev.iplan.databinding.FragmentEmployeeBinding


class EmployeeFragment : BaseFragment<FragmentEmployeeBinding> (
    FragmentEmployeeBinding::inflate
){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUI()
    }

    private fun initUI() {
        initRecyclerView()
    }

    private fun initRecyclerView() {



    }
}