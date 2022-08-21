package com.safi.apps.quran.data.pojo

data class Surah(
    val id: String,
    val start: Long,
    val ayas: Long,
    val order: Long,
    val rukus: Long,
    val arabicName: String,
    val englishName: String,
    val englishMeaning: String,
    val type: String,
)