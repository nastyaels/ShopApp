package ru.nastya.myapplication.model


data class CakeInfo (
    val id: Long?,
    val name: String,
    val calories: Double?,
    val image: String,
    val price: Double?,
    val weight: Double?,
    val ingredients: String

) {
    companion object {
        fun emptyCakeInfo() = CakeInfo(
            null,
            "", null,
            "", null, null,""
        )
    }
}