package com.safi.apps.quran.data.api

import com.safi.apps.quran.data.parser.SurahListParser
import com.safi.apps.quran.data.pojo.Surah

class SurahApiImpl(
    val parser: SurahListParser
) : SurahApi {
    override suspend fun getAll(): List<Surah> = parser.loadSurahList()

}