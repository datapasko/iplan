package com.tapascodev.iplan.home.ui

import com.tapascodev.iplan.base.domain.BaseRepository
import com.tapascodev.iplan.base.ui.BaseViewModel
import com.tapascodev.iplan.home.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserRepository
): BaseViewModel(repository) {
}