package com.dasonick.beautymodelapp.base

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("town") val town: String,
    @SerializedName("username") val phone: String,
    @SerializedName("stars") val stars: Double?,
    @SerializedName("feedbacks") val feedbacks: List<Feedback>?,
    @SerializedName("services") val myServices: List<BeautyService>?,
    @SerializedName("type") val type: Type
){
    enum class Type(val value: Int){
        @SerializedName("2") MASTER(2),
        @SerializedName("1") MODEL(1)
    }
}
