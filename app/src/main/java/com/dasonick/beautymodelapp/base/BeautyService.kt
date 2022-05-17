package com.dasonick.beautymodelapp.base

import com.google.gson.annotations.SerializedName

data class BeautyService(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Int,
    @SerializedName("photo") val imageUrl: String,
    @SerializedName("master_id") val masterId: Int,
    @SerializedName("master_name") val masterName: String,
    @SerializedName("category") val category: Int = 1
)
