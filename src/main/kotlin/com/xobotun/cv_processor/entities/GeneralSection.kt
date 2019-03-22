package com.xobotun.cv_processor.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.xobotun.cv_processor.util.getHumanReadableTimeSpan
import java.time.LocalDate

/**
 * General information on a specimen.
 */
data class GeneralSection(
    val name:           String,
    val race:           String,
    val gender:         String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val birthday:       LocalDate,
    val professions:    List<Profession>,
    val alignment:      String,
    val location:       String,
    @JsonProperty("photo_url")
    val photoUrl:       String,
    val phone:          String,
    val email:          String,
    val profiles:       List<ProfileLink>
) {
    val age:            String by lazy { getHumanReadableTimeSpan(birthday) }
}

/**
 * Describes a single profession.
 */
data class Profession(
    val name: String,
    val level: Int
)

/**
 * Link to another webpage with more obsolete data.
 */
data class ProfileLink(
    val name: String,
    val link: String,
    val img: String
)
