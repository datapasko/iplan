package com.tapascodev.iplan.network.data

import android.content.Context
import android.util.Log
import com.tapascodev.iplan.storage.data.UserPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor() {

    @Inject
    lateinit var preferences: UserPreferences
    companion object{
        private const val BASE_URL = "https://ipgo.es/api/"
    }

    fun <Api> buildApi(
        api: Class<Api>,
        context: Context
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getRetrofitClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    private fun getRetrofitClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val token = runBlocking(Dispatchers.IO) {
            preferences.accessToken.firstOrNull().toString()
        }

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().also {
                        it.addHeader("Authorization", "Bearer $token")
                    }.build()
                )
            }
            .build()
    }
}