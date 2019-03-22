package com.xobotun.cv_processor.util

import java.time.LocalDate

fun getHumanReadableTimeSpan(from: LocalDate, to: LocalDate = LocalDate.now()) : String = from.toString() + " — " + to.toString();
