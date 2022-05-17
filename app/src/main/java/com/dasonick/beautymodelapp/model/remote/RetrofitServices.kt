package com.dasonick.beautymodelapp.model.remote

import com.dasonick.beautymodelapp.base.*
import com.dasonick.beautymodelapp.model.Response
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    // master
    @GET("services/my")
    fun getMyServices(
        @Header("authorization") token: String
    ): Call<List<BeautyService>>

    @GET("services/recommended")
    fun getRecommendedServices(
        @Query("town") town: String,
        @Header("authorization") token: String
    ): Call<List<BeautyService>>

    @GET("services/category")
    fun getServicesByCategory(
        @Query("category") category: Int,
        @Query("town") town: String,
        @Header("authorization") token: String
    ): Call<List<BeautyService>>

    @GET("services")
    fun getServicesByQuestion(
        @Query("q") question: String,
        @Query("town") town: String,
        @Header("authorization") token: String
    ): Call<List<BeautyService>>

    @GET("masters/top")
    fun getTopOfMastersInTown(
        @Query("town") town: String,
        @Header("authorization") token: String
    ): Call<List<Person>>

    @GET("masters")
    fun getMasterById(
        @Query("id") id: Int,
        @Header("authorization") token: String
    ): Call<Person>

    @GET("models")
    fun getModelById(
        @Query("id") id: Int,
        @Header("authorization") token: String
    ): Call<Person>

    @PUT("service")
    fun createBeautyService(
        @Query("beauty_service") beautyService: BeautyService,
        @Header("authorization") token: String
    ): Call<Response>

    @DELETE("beauty_services/delete")
    fun deleteBeautyService(
        @Query("service_id") serviceId: Int,
        @Header("authorization") token: String
    ): Call<Response>

    @POST("auth")
    fun authByPhoneNumber(
        @Body credentials: Credentials
    ): Call<Token>

    @POST("register")
    fun registrationByPhoneNumber(
        @Body person: RegisterPerson
    ): Call<Token>

    @POST("feedback")
    fun addFeedback(
        @Query("feedback") feedback: Feedback,
        @Header("authorization") token: String
    ): Call<Response>

    @GET("account")
    fun getMyInfo(
        @Header("authorization") token: String
    ): Call<Person>
}