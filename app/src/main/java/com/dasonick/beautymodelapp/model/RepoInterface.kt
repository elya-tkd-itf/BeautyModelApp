package com.dasonick.beautymodelapp.model

import android.content.Context
import com.dasonick.beautymodelapp.base.BeautyService
import com.dasonick.beautymodelapp.base.Person

interface RepoInterface {
    suspend fun getMyServices(token: String): List<BeautyService>?
    suspend fun getRecommendedServices(town: String, token: String): List<BeautyService>?
    suspend fun getServicesByCategory(
        categoryId: Int,
        town: String,
        token: String
    ): List<BeautyService>?

    suspend fun getServicesByQuestion(
        question: String,
        town: String,
        token: String
    ): List<BeautyService>?

    suspend fun getTopOfMastersInTown(town: String, token: String): List<Person>?
    suspend fun getMasterById(id: Int): Person?
    suspend fun getModelById(id: Int): Person?

    suspend fun createBeautyService(beautyService: BeautyService, token: String): Response
    suspend fun deleteBeautyService(serviceId: Int, token: String): Response

    suspend fun authByPhoneNumber(phoneNumber: String, hashPassword: String): String?
    suspend fun registrationByPhoneNumber(
        name: String, phoneNumber: String, town: String, type: Int, password: String
    ): String?

    suspend fun getMyInfo(token: String): Person?
}