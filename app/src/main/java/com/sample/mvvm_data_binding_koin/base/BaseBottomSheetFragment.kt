package com.sample.mvvm_data_binding_koin.base

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import kotlin.reflect.KClass

open class BaseBottomSheetFragment<T : BaseViewModel>(clazz: KClass<T>) : BottomSheetDialogFragment() {

    val viewModel: T by sharedViewModel(clazz = clazz)

}