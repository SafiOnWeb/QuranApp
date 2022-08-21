package com.safi.apps.quran.data.collection

import com.google.firebase.firestore.FirebaseFirestore

class ReciterCollection(firestore: FirebaseFirestore) :
    FirestoreCollection(firestore.collection(COLLECTION_NAME)) {
    companion object {
        private const val COLLECTION_NAME = "Reciter"
    }
}