package com.tapascodev.iplan.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.tapascodev.iplan.base.domain.BaseRepository
import java.lang.IllegalArgumentException

abstract class BaseFragment<VB: ViewBinding> (
    private val bindingInflater: (inflater: LayoutInflater) -> VB
) : Fragment () {

    private var _binding : VB? = null

    val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)

        if (_binding == null)
            throw IllegalArgumentException("Binding cannot be null")

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}