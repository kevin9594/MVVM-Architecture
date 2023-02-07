package com.sample.mvvm_data_binding_koin.base

import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import kotlin.reflect.KClass

open class BaseDialog<T : BaseViewModel>(clazz: KClass<T>) : DialogFragment() {

    val viewModel: T by sharedViewModel(clazz = clazz)

    init {
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) //hide keyboard
    }

    protected fun setStyle (style: Int) {
        setStyle(STYLE_NO_TITLE, style)
    }

}
