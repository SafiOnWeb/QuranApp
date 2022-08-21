package com.safi.apps.quran.data.dto

import com.safi.apps.quran.data.pojo.Recitation

data class RecitationDto(
    val id: String,
    val surahId: String,
    val reciterId: String,
    val link: String
) {
    constructor() : this("", "", "", "")

    val asRecitation get() = Recitation(id, surahId, reciterId, link)
}