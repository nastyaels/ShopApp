package ru.nastya.myapplication.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.nastya.myapplication.data.network.services.CakeService
import ru.nastya.myapplication.data.network.services.CakeServiceApi

internal object AppNetwork {
    private val gson = GsonBuilder().create()

    private val client = OkHttpClient().newBuilder().build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("http://192.168.0.103:8080/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val cakeService by lazy {
        val cakeServiceApi = retrofit.create(CakeServiceApi::class.java)
        CakeService(cakeServiceApi)
    }
}