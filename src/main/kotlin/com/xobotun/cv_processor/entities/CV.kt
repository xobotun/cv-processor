package com.xobotun.cv_processor.entities

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Main container for a single resume data.
 */
data class CV(
                                        val general:            GeneralSection,
    @JsonProperty("job_history")        val jobHistory:         JobHistory,
    @JsonProperty("education_history")  val educationHistory:   EducationHistory,
                                        val skills:             SkillSection,
    @JsonProperty("books_read")         val booksRead:          BooksSection
)
