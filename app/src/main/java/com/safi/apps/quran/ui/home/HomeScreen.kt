package com.safi.apps.quran.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.safi.apps.quran.R
import com.safi.apps.quran.data.api.SurahApiImpl
import com.safi.apps.quran.data.collection.SurahCollection
import com.safi.apps.quran.data.pojo.Surah

@Composable
fun HomeScreen() {
    val api = SurahApiImpl(SurahCollection(Firebase.firestore))
    val data = produceState<List<Surah>>(initialValue = emptyList()) {
        value = api.getAll()
    }
    LazyColumn(Modifier.background(Color.LightGray)) {
        items(data.value.size) { index ->
            data.value[index].AsComposable()
        }
    }
}


@Composable
private fun Surah.AsComposable() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(
            text = englishName,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_play_arrow_24),
            contentDescription = "Play",
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}