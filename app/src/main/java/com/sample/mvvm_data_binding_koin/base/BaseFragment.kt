package com.sample.mvvm_data_binding_koin.base

import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import kotlin.reflect.KClass

open class BaseFragment<T : BaseViewModel>(clazz: KClass<T>) : Fragment() {
    val viewModel: T by sharedViewModel(clazz = clazz)
}
