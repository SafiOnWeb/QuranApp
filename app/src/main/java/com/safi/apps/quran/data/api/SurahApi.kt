package com.safi.apps.quran.data.api

import com.safi.apps.quran.data.collection.SurahCollection
import com.safi.apps.quran.data.dto.SurahDto
import com.safi.apps.quran.data.pojo.Surah
import kotlinx.coroutines.tasks.await

class SurahApi(
    private val surahCollection: SurahCollection
) {
    suspend fun getAll(): List<Surah> =
        surahCollection.collectionReference.get().await().documents.mapNotNull {
            it.toObject(SurahDto::class.java)?.copy(id = it.id)?.asObject
        }.sortedBy { it.start }


}