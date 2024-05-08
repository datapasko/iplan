package com.tapascodev.iplan.home.domain

import com.tapascodev.iplan.base.domain.BaseRepository
import com.tapascodev.iplan.home.data.UserApi
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserApi
) : BaseRepository(api) {
}