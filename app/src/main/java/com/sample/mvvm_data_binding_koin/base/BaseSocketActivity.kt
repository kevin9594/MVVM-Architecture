package com.sample.mvvm_data_binding_koin.base

import android.content.*
import android.os.Bundle
import android.os.IBinder
import kotlin.reflect.KClass

abstract class BaseSocketActivity<T : BaseSocketViewModel>(clazz: KClass<T>) :
    BaseActivity<T>(clazz) {

    val receiver by lazy {
        //BroadcastReceiver
    }

    private var isServiceBound = false
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            isServiceBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isServiceBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        subscribeBroadCastReceiver()
        bindService()
    }

    override fun onStop() {
        super.onStop()
        removeBroadCastReceiver()
        unBindService()
    }

    private fun bindService() {
        if (isServiceBound) return
    }

    private fun unBindService() {
        if (!isServiceBound) return
        unbindService(serviceConnection)
        isServiceBound = false
    }

    private fun subscribeBroadCastReceiver() {}

    private fun removeBroadCastReceiver() {}

}