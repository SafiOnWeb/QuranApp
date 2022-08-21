package com.safi.apps.quran.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity


fun Context.playMusic(url: String) {
    val uri: Uri = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.setDataAndType(uri, "audio/*")
    startActivity(intent)
}