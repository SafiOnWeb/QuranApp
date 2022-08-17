package com.safi.apps.quran.data.api

import com.safi.apps.quran.data.pojo.Surah
import kotlinx.coroutines.flow.Flow

interface SurahApi {
    suspend fun getAll(): List<Surah>
}