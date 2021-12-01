package ru.nastya.myapplication.data.network.services

import retrofit2.Response
import ru.nastya.myapplication.data.network.model.CakeInfoNet
import ru.nastya.myapplication.data.network.model.CakeListNet

internal class CakeService (
    private val apiService: CakeServiceApi
    ){
    suspend fun getCakes(): Response<CakeListNet> {
        println("ok")
        return apiService.getGakes()
    }
    suspend fun getCakeById(id: Long):Response<CakeInfoNet> = apiService.getCakeById(id)
}
