package com.xobotun.cv_processor.util

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*
import kotlin.collections.ArrayList

var myDateLocale: String = "global variable, wow! Never imagined I'd write one.";

// No way to format in Java 8
fun getHumanReadableTimeSpan(from: LocalDate, to: LocalDate = LocalDate.now()) : String {
    val duration = Period.between(from, to.plusDays(1))

    val experienceParts = ArrayList<String>()

    if (myDateLocale == "ru") {
        if (duration.years  > 0) experienceParts.add(formatDateInteger(duration.years, arrayOf("год", "года", "лет")))
        if (duration.months > 0) experienceParts.add(formatDateInteger(duration.months, arrayOf("месяц", "месяца", "месяцев")))
    }

    if (myDateLocale == "en") {
        if (duration.years  > 0) experienceParts.add(formatDateInteger(duration.years, arrayOf("year", "years", "years")))
        if (duration.months > 0) experienceParts.add(formatDateInteger(duration.months, arrayOf("month", "months", "months")))
    }

    return experienceParts.joinToString(" ")
}

fun getHumanReadableLocalDate(date: LocalDate) = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale(myDateLocale)).format(date)!!

/**
 * Formats input to human-readable format.
 * Usage:   1, ["day", "days", "days"] → 1 day
 *          2, ["day", "days", "days"] → 1 days
 */
private fun formatDateInteger(int: Int, tokens: Array<String>) : String {
    var yearsSuffix = when (int % 10) {
        1 -> tokens[0]
        2, 3, 4 -> tokens[1]
        else -> tokens[2]
    }

    if (int % 100 == 11 || int % 100 == 12)
        yearsSuffix = tokens[2];

    return int.toString() + " " + yearsSuffix;
}

