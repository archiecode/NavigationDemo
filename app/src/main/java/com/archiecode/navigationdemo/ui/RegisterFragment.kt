package com.archiecode.navigationdemo.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.archiecode.navigationdemo.R
import com.carwash.carwashbusiness.util.ext.hideSoftkeyboard
import com.carwash.carwashbusiness.util.ext.setupToolbar
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.toast

class RegisterFragment: Fragment() {
    private lateinit var rootView:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_register, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        setupToolbar(toolbar, R.string.register)
        rootView.registerBtn.setOnClickListener {
            hideSoftkeyboard()
            toast("注册成功")
            Navigation.findNavController(rootView).popBackStack(R.id.homeFragment, false)
            (activity as MainActivity).onLoginAction.invoke(rootView.userEdit.text.toString())
        }
        val email = arguments?.getString("email") ?: ""
        if (email.isNotBlank()) {
            rootView.userEdit.setText(email)
        }
    }
}