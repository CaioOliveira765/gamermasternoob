package com.example.gamernoob.firebasedata

import android.content.ContentValues.TAG
import android.media.MediaPlayer
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class FireBaseGetData private constructor() {

    // Access a Cloud Firestore instance from your Activity

    var db = FirebaseFirestore.getInstance()

    object Holder {
        val value = synchronized(FireBaseGetData::class.java) { FireBaseGetData() }

    }

    companion object {
        val instance: FireBaseGetData by lazy { Holder.value }
    }

    public fun getQuotesFromFireStore() {
        db.collection(FirebaseConstants.COLLECTION_PARENT)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    task.result
                        .asSequence()
                        .filter { it.id == FirebaseConstants.DOCUMENT_PARENT }
                        .forEach {
                            prepareData(
                                it.data[FirebaseConstants.FIELD_CONTENT] as
                                        List<HashMap<String, String>>
                            )
                        }

                } else {

                }

            }

    }

    private fun prepareData(list: List<HashMap<String, String>>) {

    }
}


