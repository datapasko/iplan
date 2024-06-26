package com.tapascodev.iplan

import android.content.Context
import com.tapascodev.iplan.auth.data.AuthApi
import com.tapascodev.iplan.auth.data.AuthInterceptor
import com.tapascodev.iplan.employee.data.EmployeeApi
import com.tapascodev.iplan.home.data.UserApi
import com.tapascodev.iplan.network.data.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAuthApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): AuthApi {
        return remoteDataSource.buildApi(AuthApi::class.java, context)
    }

    @Singleton
    @Provides
    fun provideUserApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): UserApi {
        return remoteDataSource.buildApi(UserApi::class.java, context)
    }

    @Singleton
    @Provides
    fun provideEmployeeApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): EmployeeApi {
        return remoteDataSource.buildApi(EmployeeApi::class.java, context)
    }
}