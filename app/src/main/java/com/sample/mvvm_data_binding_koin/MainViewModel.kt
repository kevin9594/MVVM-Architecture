package com.sample.mvvm_data_binding_koin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.sample.mvvm_data_binding_koin.base.BaseViewModel
import com.sample.mvvm_data_binding_koin.repository.LoginRepository

class MainViewModel(loginRepository: LoginRepository) : BaseViewModel(loginRepository) {

    private val _data = MutableLiveData<LoginResult?>()
    val data: LiveData<LoginResult?>
        get() = _data

    fun getData() {
        viewModelScope.launch {
            val result = doNetwork {
                TestApi.indexService.login()
            }
            _data.postValue(result)
        }
    }

}