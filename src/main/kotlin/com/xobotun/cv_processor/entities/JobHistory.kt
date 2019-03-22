package com.xobotun.cv_processor.entities

import com.fasterxml.jackson.annotation.JsonClassDescription
import com.fasterxml.jackson.annotation.JsonProperty
import com.xobotun.cv_processor.getHumanReadableTimeSpan
import java.time.LocalDate

/**
 * More specific information on specimen's working history
 */
data class JobHistory(
    val name:                   String,
    val where:                  String,
    val began:                  LocalDate,
    val ended:                  LocalDate = LocalDate.now(),
    @JsonProperty("workplace_description")
    val workplaceDescription:   String,
    @JsonProperty("job_description")
    val jobDescription:         String,
    val relatedSkills:          List<String>
) {
    val experience:             String by lazy { getHumanReadableTimeSpan(began, ended)}
}
