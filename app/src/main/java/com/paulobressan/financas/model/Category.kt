package com.paulobressan.financas.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("_id")
    val id: String,
    val name: String
)