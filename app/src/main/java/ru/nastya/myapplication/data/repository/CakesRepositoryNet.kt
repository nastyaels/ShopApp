package ru.nastya.myapplication.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nastya.myapplication.data.network.AppNetwork
import ru.nastya.myapplication.data.network.model.CakeInfoNet
import ru.nastya.myapplication.model.Cake
import ru.nastya.myapplication.model.CakeInfo


class CakesRepositoryNet (
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
    private val cakeService = AppNetwork.cakeService

    suspend fun cakeList(): List<Cake> = withContext(defaultDispatcher){
        val response = cakeService.getCakes()
        val cakeList = if(response.isSuccessful){
            response.body()?.cake_list ?: listOf()
        } else listOf()

        cakeList.map {
            with(it) {
                Cake(id,name,calories?.toDouble(),image,price?.toDouble(), weight?.toDouble())
            }
        }
    }

    suspend fun cake(id: Long): CakeInfo = withContext(defaultDispatcher){
        val response = cakeService.getCakeById(id)
        val cake = if(response.isSuccessful){
            response.body() ?: CakeInfoNet.emptyCakeInfoNet()
        } else CakeInfoNet.emptyCakeInfoNet()
        var cakeInfo: CakeInfo
        cake.apply {
            cakeInfo = CakeInfo(id,name,calories?.toDouble(),image,price?.toDouble(),weight?.toDouble(),ingredients)
        }
        cakeInfo
    }
}