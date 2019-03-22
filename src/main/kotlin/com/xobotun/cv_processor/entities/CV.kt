package com.xobotun.cv_processor.entities

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Main container for a single resume data.
 */
data class CV(
                                        val meta:               Meta,
                                        val general:            GeneralSection,
    @JsonProperty("job_history")        val jobHistory:         List<JobHistory>,
    @JsonProperty("education_history")  val educationHistory:   List<EducationHistory>,
                                        val skills:             List<SkillSection>,
    @JsonProperty("books_read")         val booksRead:          BooksSection
)
