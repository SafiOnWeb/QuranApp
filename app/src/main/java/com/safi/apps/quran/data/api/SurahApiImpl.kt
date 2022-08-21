package com.safi.apps.quran.data.api

import com.google.firebase.firestore.FirebaseFirestore
import com.safi.apps.quran.data.collection.SurahCollection
import com.safi.apps.quran.data.dto.SurahDto
import com.safi.apps.quran.data.pojo.Surah
import com.safi.apps.quran.util.logD
import kotlinx.coroutines.tasks.await

class SurahApiImpl(
    private val surahCollection: SurahCollection
) : SurahApi {
    override suspend fun getAll(): List<Surah> =
        surahCollection.collectionReference.get().await().toObjects(SurahDto::class.java)
            .map { it.asObject }

}