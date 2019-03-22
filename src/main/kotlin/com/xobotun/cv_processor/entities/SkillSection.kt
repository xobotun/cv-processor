package com.xobotun.cv_processor.entities

import com.fasterxml.jackson.annotation.JsonClassDescription
import com.fasterxml.jackson.annotation.JsonProperty
import com.xobotun.cv_processor.getHumanReadableTimeSpan
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
    val began:                  LocalDate,
    val description:            String,
    val relatedSkills:          List<Subskill>
) {
    val experience: String by lazy { getHumanReadableTimeSpan(began) }
}

/**
 * A more specific skill.
 */
data class Subskill(
    val name:                   String,
    val level:                  Int
)
