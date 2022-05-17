package com.dasonick.beautymodelapp.model

import android.content.Context
import android.util.Log
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.base.BeautyService
import com.dasonick.beautymodelapp.base.Credentials
import com.dasonick.beautymodelapp.base.Person
import com.dasonick.beautymodelapp.base.RegisterPerson
import com.dasonick.beautymodelapp.model.remote.Common

class Repository : RepoInterface {
    //TODO("Not local storage checked")
    private val retrofitService = Common.retrofitService

    override suspend fun getMyServices(token: String): List<BeautyService>? {
        val result = retrofitService.getMyServices("Bearer $token").execute()
        if (result.isSuccessful) return result.body()
        return null
    }

    override suspend fun getRecommendedServices(town: String, token: String): List<BeautyService>? {
        val result = retrofitService.getRecommendedServices(town, "Bearer $token").execute()
        if (result.isSuccessful) return result.body()
        return null
    }

    override suspend fun getServicesByCategory(
        categoryId: Int,
        town: String,
        token: String
    ): List<BeautyService>? {
        val result =
            retrofitService.getServicesByCategory(categoryId, town, "Bearer $token").execute()
        if (result.isSuccessful) return result.body()
        return null
    }

    override suspend fun getServicesByQuestion(
        question: String,
        town: String,
        token: String
    ): List<BeautyService>? {
        val result =
            retrofitService.getServicesByQuestion(question, town, "Bearer $token").execute()
        if (result.isSuccessful) return result.body()
        return null
    }

    override suspend fun getTopOfMastersInTown(town: String, token: String): List<Person>? {
        val result = retrofitService.getTopOfMastersInTown(town, "Bearer $token").execute()
        if (result.isSuccessful) return result.body()
        return null
    }

    override suspend fun getMasterById(id: Int): Person? {
        TODO("Not yet implemented")
    }

    override suspend fun getModelById(id: Int): Person? {
        TODO("Not yet implemented")
    }

    override suspend fun createBeautyService(
        beautyService: BeautyService,
        token: String
    ): Response {
        val result = retrofitService.createBeautyService(beautyService, token).execute()
        if (result.isSuccessful) return Response.OK
        return Response.FAIL
    }

    override suspend fun deleteBeautyService(serviceId: Int, token: String): Response {
        val result = retrofitService.deleteBeautyService(serviceId, "Bearer $token").execute()
        if (result.isSuccessful) return Response.OK
        return Response.FAIL
    }

    //TODO("Not yet implemented")
    override suspend fun authByPhoneNumber(
        phoneNumber: String,
        hashPassword: String
    ): String? {
        val result =
            retrofitService.authByPhoneNumber(Credentials(phoneNumber, hashPassword)).execute()
        if (result.isSuccessful) {
            return result.body()?.token
        }
        return null
    }

    override suspend fun registrationByPhoneNumber(
        name: String,
        phoneNumber: String,
        town: String,
        type: Int,
        password: String
    ): String? {
        val result = retrofitService.registrationByPhoneNumber(
            RegisterPerson(name, phoneNumber, town, type + 1, password)
        ).execute()
        if (result.isSuccessful) {
            return result.body()?.token
        }
        return null
    }

    override suspend fun getMyInfo(token: String): Person? {
        val result = retrofitService.getMyInfo("Bearer $token").execute()
        if (result.isSuccessful) return result.body()
        return null
    }
}