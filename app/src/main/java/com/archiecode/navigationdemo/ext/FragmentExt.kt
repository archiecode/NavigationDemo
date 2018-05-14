package com.carwash.carwashbusiness.util.ext

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.inputmethod.InputMethodManager
import com.archiecode.navigationdemo.R


fun Fragment.hideSoftkeyboard() {
    val view = activity?.currentFocus
    if (view != null) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Fragment.setupToolbar(toolbar: Toolbar, @StringRes title:Int) {
    toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white)
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).supportActionBar?.title = getString(title)
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener { (activity as AppCompatActivity).onBackPressed() }
}

fun Fragment.setupToolbar(toolbar: Toolbar, title:CharSequence) {
    toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white)
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).supportActionBar?.title = title
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener { (activity as AppCompatActivity).onBackPressed() }
}
