package com.archiecode.navigationdemo.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.archiecode.navigationdemo.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.home_content.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class UserFragment: Fragment(), AnkoLogger {

    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        info { "onViewCreate" }
        initView()
    }

    private fun initView() {
        rootView.fab.setOnClickListener {
            Navigation.findNavController(rootView).navigate(R.id.action_home_screen_to_loginFragment)
        }
        val userName = arguments?.getString("email")?:""
        if (userName.isNotBlank()) {
            rootView.homeContent.text = userName
        }
    }
}