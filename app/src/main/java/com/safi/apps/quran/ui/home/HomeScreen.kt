package com.safi.apps.quran.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.safi.apps.quran.R
import com.safi.apps.quran.data.api.RecitationApi
import com.safi.apps.quran.data.api.ReciterApi
import com.safi.apps.quran.data.api.SurahApi
import com.safi.apps.quran.data.collection.RecitationCollection
import com.safi.apps.quran.data.collection.ReciterCollection
import com.safi.apps.quran.data.collection.SurahCollection
import com.safi.apps.quran.data.pojo.Reciter
import com.safi.apps.quran.data.pojo.Surah
import com.safi.apps.quran.util.playMusic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    // TODO: User DI here
    val surahApi = SurahApi(SurahCollection(Firebase.firestore))
    val reciterApi = ReciterApi(ReciterCollection(Firebase.firestore))
    val recitationApi = RecitationApi(RecitationCollection(Firebase.firestore))

    val surahList = produceState<List<Surah>>(initialValue = emptyList()) {
        value = surahApi.getAll()
    }

    val reciterList = produceState<List<Reciter>>(initialValue = emptyList()) {
        value = reciterApi.getAll()
    }
    LazyColumn(Modifier.background(Color.LightGray)) {
        items(surahList.value.size) { index ->
            surahList.value[index].AsComposable {
                scope.launch(Dispatchers.IO) {
                    recitationApi.get(surahList.value[index], reciterList.value.first())?.let {
                        context.playMusic(it.link)
                    }
                }
            }
        }
    }
}


@Composable
private fun Surah.AsComposable(onPlay: () -> Unit) {
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
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable {
                    onPlay()
                }
        )
    }
}