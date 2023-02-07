package com.sample.mvvm_data_binding_koin.base

import com.sample.mvvm_data_binding_koin.repository.LoginRepository

abstract class BaseSocketViewModel(loginRepository: LoginRepository, ) : BaseViewModel(loginRepository) {

}