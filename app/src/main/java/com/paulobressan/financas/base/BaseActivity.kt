package com.paulobressan.financas.base

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.paulobressan.financas.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
    }

    abstract fun layoutId(): Int

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}