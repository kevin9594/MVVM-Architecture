package com.sample.mvvm_data_binding_koin.repository

import android.content.Context
import android.content.SharedPreferences
import com.sample.mvvm_data_binding_koin.LoginRequest
import com.sample.mvvm_data_binding_koin.LoginResult
import com.sample.mvvm_data_binding_koin.TestApi
import com.sample.mvvm_data_binding_koin.LoginData
import retrofit2.Response

const val NAME_LOGIN = "login"
const val KEY_TOKEN = "token"

class LoginRepository(private val androidContext: Context) {

    private val sharedPref: SharedPreferences by lazy {
        androidContext.getSharedPreferences(NAME_LOGIN, Context.MODE_PRIVATE)
    }

    var token
        get() = sharedPref.getString(KEY_TOKEN, "")
        set(value) {
            with(sharedPref.edit()) {
                putString(KEY_TOKEN, value)
                apply()
            }
        }

    suspend fun login(loginRequest: LoginRequest): Response<LoginResult> {
        val loginResponse = TestApi.indexService.login()
        if (loginResponse.isSuccessful) {
            loginResponse.body()?.let {
                updateLoginData(it.loginData)
            }
        }
        return loginResponse
    }

    private fun updateLoginData(loginData: LoginData?) {
        with(sharedPref.edit()) {
            putString(KEY_TOKEN, loginData?.token)
            apply()
        }
    }


    suspend fun clear() {
        with(sharedPref.edit()) {
            remove(KEY_TOKEN)
            apply()
        }
    }

}