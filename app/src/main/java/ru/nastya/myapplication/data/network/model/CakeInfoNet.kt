package ru.nastya.myapplication.data.network.model

import java.math.BigDecimal

data class CakeInfoNet (
    val id: Long?,
    val name: String,
    val calories: BigDecimal?,
    val image: String,
    val price: BigDecimal?,
    val weight: BigDecimal?,
    val ingredients: String

) {
    companion object {
        fun emptyCakeInfo() = CakeInfoNet(
            null,
            "", null,
            "", null, null,""
        )
    }
}