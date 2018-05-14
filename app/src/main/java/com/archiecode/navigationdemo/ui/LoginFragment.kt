package com.archiecode.navigationdemo.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.archiecode.navigationdemo.R
import com.carwash.carwashbusiness.util.ext.hideSoftkeyboard
import com.carwash.carwashbusiness.util.ext.setupToolbar
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.toast

class LoginFragment: Fragment() {
    private lateinit var rootView:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_login, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        setupToolbar(toolbar, R.string.login)
        rootView.loginBtn.setOnClickListener {
            hideSoftkeyboard()
            toast("登录成功")
            Navigation.findNavController(rootView).navigateUp()
            (activity as MainActivity).onLoginAction.invoke(rootView.userEdit.text.toString())
        }
        rootView.navRegister.setOnClickListener {
            val args = bundleOf("email" to rootView.userEdit.text.toString())
            Navigation.findNavController(rootView).navigate(R.id.action_loginFragment_to_registerFragment, args)
        }
    }
}