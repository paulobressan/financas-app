package com.paulobressan.financas

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun Date.format(pattern: String): String {
    val formated = SimpleDateFormat(pattern)
    return formated.format(this)
}