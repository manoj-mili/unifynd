package com.mili.unifynd.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.mili.unifynd.BaseApp

open class BaseActivity : AppCompatActivity() {
    val injector by lazy {
        (application as BaseApp).appInjector
    }
}