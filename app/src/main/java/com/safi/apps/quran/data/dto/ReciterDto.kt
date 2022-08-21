package com.safi.apps.quran.data.dto

import com.safi.apps.quran.data.pojo.Reciter

data class ReciterDto(
    val id: String,
    val name: String
) {
    constructor() : this("", "")

    val asReciter get() = Reciter(id, name)
}