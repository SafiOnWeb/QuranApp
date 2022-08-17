package com.safi.apps.quran.util

import android.util.Log
import com.safi.apps.quran.BuildConfig

private const val TAG = ">>>>"
fun Any?.logD(tag: String = TAG) {
    if (BuildConfig.DEBUG) {
        Log.d(tag, this.toString())
    }
}