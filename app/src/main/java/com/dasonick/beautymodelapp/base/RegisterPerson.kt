package com.dasonick.beautymodelapp.base

import com.google.gson.annotations.SerializedName

data class RegisterPerson(
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("town") val town: String,
    @SerializedName("type") val type: Int,
    @SerializedName("password") val password: String
)