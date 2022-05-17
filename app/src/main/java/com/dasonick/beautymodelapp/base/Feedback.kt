package com.dasonick.beautymodelapp.base

import com.google.gson.annotations.SerializedName

data class Feedback(
    @SerializedName("id") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("stars") val stars: Int,
    @SerializedName("author_id") val authorId: Int,
    @SerializedName("author_name") val authorName: String
)
