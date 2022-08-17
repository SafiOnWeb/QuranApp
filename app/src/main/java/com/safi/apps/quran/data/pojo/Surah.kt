package com.safi.apps.quran.data.pojo

data class Surah(
    val start: Long,
    val ayas: Long,
    val order: Long,
    val rukus: Long,
    val arabicName: String,
    val englishName: String,
    val englishMeaning: String,
    val type: String,
) {
    companion object {
        fun fromStringList(list: List<String>) = Surah(
            list[0].trim().toLong(),
            list[1].trim().toLong(),
            list[2].trim().toLong(),
            list[3].trim().toLong(),
            list[4].trim().removeSurrounding("\""),
            list[5].trim().removeSurrounding("\""),
            list[6].trim().removeSurrounding("\""),
            list[7].trim().removeSurrounding("\""),
        )
    }
}