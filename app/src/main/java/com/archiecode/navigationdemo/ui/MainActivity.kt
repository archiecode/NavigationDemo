package com.archiecode.navigationdemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.archiecode.navigationdemo.R

class MainActivity : AppCompatActivity() {
    lateinit var onLoginAction: (String) -> Unit
    lateinit var onRegisterAction: (String) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
