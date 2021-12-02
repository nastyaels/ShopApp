package ru.nastya.myapplication.data.network.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.nastya.myapplication.data.network.model.CakeInfoNet
import ru.nastya.myapplication.data.network.model.CakeListNet

internal interface CakeServiceApi {
    @GET("cakes")
    suspend fun getCakes(): Response<CakeListNet>

    @GET("cake/{id}")
    suspend fun getCakeById(@Path("id") id:Long) : Response<CakeInfoNet>
}