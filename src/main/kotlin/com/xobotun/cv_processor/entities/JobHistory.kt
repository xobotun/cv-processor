package com.xobotun.cv_processor.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.xobotun.cv_processor.util.getHumanReadableTimeSpan
import java.time.LocalDate

/**
 * More specific information on specimen's working history
 */
data class JobHistory(
    val name:                   String,
    val where:                  String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val began:                  LocalDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val ended:                  LocalDate = LocalDate.now(),
    @JsonProperty("workplace_description")
    val workplaceDescription:   String,
    @JsonProperty("job_description")
    val jobDescription:         String,
    @JsonProperty("related_skills")
    val relatedSkills:          List<String>
) {
    val experience:             String by lazy { getHumanReadableTimeSpan(began, ended) }
}
