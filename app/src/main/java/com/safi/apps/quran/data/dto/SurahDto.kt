package com.safi.apps.quran.data.dto

import com.safi.apps.quran.data.pojo.Surah

data class SurahDto(
    val id: String,
    val start: Long,
    val ayas: Long,
    val order: Long,
    val rukus: Long,
    val arabicName: String,
    val englishName: String,
    val englishMeaning: String,
    val type: String,
) {
    constructor() : this("", 0L, 0L, 0L, 0L, "", "", "", "") {

    }

    val asObject
        get() = Surah(
            id,
            start,
            ayas,
            order,
            rukus,
            arabicName,
            englishName,
            englishMeaning,
            type
        )
}