package com.dasonick.beautymodelapp.model.remote

object Common {
    private const val BASE_URL = "http://elya.yank0vy3rdna.ru/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}