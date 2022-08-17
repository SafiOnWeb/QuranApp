package com.safi.apps.quran.util

import java.util.regex.Matcher
import java.util.regex.Pattern

fun String.applyRegex(regex: String, group: Int): MutableList<String> {
    val matches = mutableListOf<String>()
    val p: Pattern = Pattern.compile(regex)
    val m: Matcher = p.matcher(this)
    while (m.find()) {
        m.group(group)?.let { matches.add(it) }
    }
    return matches
}