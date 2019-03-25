package com.xobotun.cv_processor.processor.parts

import com.xobotun.cv_processor.entities.Book
import com.xobotun.cv_processor.entities.CV

class BooksSection(val cv: CV) {
    val books: String = Books(cv).processed

    val processed: String = """
       |        <section class="section">
       |            <header id="books_read" class="section__header">${cv.meta.localization["books_read"]}</header>
                    $books
       |        </section>
""".trim()
}

class Books(val cv: CV) {
    val processed: String by lazy {
        var result = "";
        for (book in cv.booksRead.list) {
            result += getBooks(book) + '\n';
        }
        return@lazy result;
    }

    private fun getBooks(book: Book) = """
       |            <div class="section__contents">
       |                <header class="entry__header">
       |                    <span class="entry__header_qualification">${book.name}</span>
       |                    <br/>
       |                    <span class="entry__header_location entry__header_undertext">${book.author}</span>
       |                </header>
       |                ${book.description}
       |                <br/>
       |            </div>
""".trimIndent()
}
