package com.xobotun.cv_processor.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.xobotun.cv_processor.util.getHumanReadableTimeSpan
import java.time.LocalDate

/**
 * More specific information on specimen's skill sets.
 */
data class SkillSection(
    val name:                   String,
    val description:            String,
    val skillsets:              List<SkillSet>
)

/**
 * Represents a general skill direction.
 */
data class SkillSet(
    val name:                   String,
    val level:                  Int,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val began:                  LocalDate,
    val subskills:              List<Subskill>
) {
    val experience:             String by lazy { getHumanReadableTimeSpan(began) }
}

/**
 * A more specific skill.
 */
data class Subskill(
    val name:                   String,
    val level:                  Int
)
