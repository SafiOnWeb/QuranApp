package com.safi.apps.quran.data.api

import com.safi.apps.quran.data.collection.RecitationCollection
import com.safi.apps.quran.data.collection.RecitationCollection.Companion.RECITER_ID
import com.safi.apps.quran.data.collection.RecitationCollection.Companion.SURAH_ID
import com.safi.apps.quran.data.dto.RecitationDto
import com.safi.apps.quran.data.pojo.Reciter
import com.safi.apps.quran.data.pojo.Surah
import kotlinx.coroutines.tasks.await

class RecitationApi(private val recitationCollection: RecitationCollection) {
    suspend fun get(surah: Surah, reciter: Reciter) =
        recitationCollection.collectionReference
            .whereEqualTo(SURAH_ID, surah.id)
            .whereEqualTo(RECITER_ID, reciter.id)
            .get()
            .await()
            .documents.first().let {
                it.toObject(RecitationDto::class.java)?.copy(id = it.id)?.asRecitation
            }
}