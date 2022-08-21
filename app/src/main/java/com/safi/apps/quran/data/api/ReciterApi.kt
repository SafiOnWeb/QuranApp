package com.safi.apps.quran.data.api

import com.safi.apps.quran.data.collection.ReciterCollection
import com.safi.apps.quran.data.dto.ReciterDto
import kotlinx.coroutines.tasks.await

class ReciterApi(private val reciterCollection: ReciterCollection) {
    suspend fun getAll() =
        reciterCollection.collectionReference.get().await().documents.mapNotNull {
            it.toObject(ReciterDto::class.java)?.copy(id = it.id)?.asReciter
        }
}