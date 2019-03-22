package com.xobotun.cv_processor.entities

import com.fasterxml.jackson.annotation.JsonClassDescription
import com.fasterxml.jackson.annotation.JsonProperty
import com.xobotun.cv_processor.getHumanReadableTimeSpan
import java.time.LocalDate

/**
 * More specific information on specimen's working history
 */
data class EducationHistory(
    val name:           String,
    val type:           EducationType,
    val where:          String,
    val began:          LocalDate,
    val ended:          LocalDate = LocalDate.now(),
    val description:    String,
    @JsonProperty("proof_url")
    val proofUrl:       String?,
    @JsonProperty("photo_urls")
    val photoUrls:      List<String>
) {
    val length:         String by lazy { getHumanReadableTimeSpan(began, ended)}
}

enum class EducationType {
    Primary, Secondary
}
