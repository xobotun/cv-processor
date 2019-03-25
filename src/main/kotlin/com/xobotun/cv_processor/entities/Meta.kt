package com.xobotun.cv_processor.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.xobotun.cv_processor.util.getHumanReadableTimeSpan
import java.time.LocalDate

/**
 * Some information about what the shown webpage is.
 */
data class Meta(
    val title:          String,
    val lang:           String,
    val localization:   Map<String, String>
)
