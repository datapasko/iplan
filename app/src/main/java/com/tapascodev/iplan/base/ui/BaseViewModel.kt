package com.tapascodev.iplan.base.ui

import androidx.lifecycle.ViewModel
import com.tapascodev.iplan.base.domain.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseViewModel (
    private val repository: BaseRepository
) : ViewModel() {

    suspend fun logout() = withContext(Dispatchers.IO) { repository.logout() }
}