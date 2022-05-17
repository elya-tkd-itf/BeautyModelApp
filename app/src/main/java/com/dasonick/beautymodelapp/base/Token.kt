package com.dasonick.beautymodelapp.base

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("access_token") val token: String,
    @SerializedName("token_type") val token_type: String
)
