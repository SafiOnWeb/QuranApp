package com.safi.apps.quran.data.parser

import com.safi.apps.quran.data.pojo.Surah
import com.safi.apps.quran.util.applyRegex
import com.safi.apps.quran.util.logD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.util.regex.Matcher
import java.util.regex.Pattern

class SurahListParser {
    companion object {
        private const val URL = "https://www.searchtruth.com/quran/recitation/"
    }

    suspend fun loadSurahList() = withContext(Dispatchers.IO) {
        Jsoup.connect(URL).get()
            .getElementsByTag("script")[3].toString().trim().applyRegex("\\[(.*?)\\]", 1)
            .map { it.split(",") }
            .filter { it.size == 8 }
            .drop(1)
            .map {
                Surah.fromStringList(it)
            }
    }
}