package com.paulobressan.financas.network

data class BaseResponse<T>(
    val items: List<T>
)