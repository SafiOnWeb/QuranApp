package com.safi.apps.quran.data.collection

import com.google.firebase.firestore.FirebaseFirestore

class RecitationCollection(firestore: FirebaseFirestore) :
    FirestoreCollection(firestore.collection(COLLECTION_NAME)) {
    companion object {
        private const val COLLECTION_NAME = "Recitation"
        const val RECITER_ID = "reciterId"
        const val SURAH_ID = "surahId"
    }
}