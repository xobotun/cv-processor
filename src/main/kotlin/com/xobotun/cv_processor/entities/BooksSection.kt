package com.xobotun.cv_processor.entities

/**
 * More specific information on specimen's working history.
 */
data class BooksSection(
    val name:           String,
    val list:           List<Book>
)

/**
 * Describes a single book and specimen's attitude to it.
 */
data class Book(
    val name:           String,
    val author:         String,
    val description:    String
)
