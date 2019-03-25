package com.xobotun.cv_processor.processor.parts

import com.xobotun.cv_processor.entities.CV

class BodyContent(val cv: CV) {
    val generalSection: String = GeneralSection(cv).processed
    val jobHistory: String = JobHistorySection(cv).processed
    val educationHistory: String = EducationHistorySection(cv).processed
    val skillSection: String = ""
    val booksSection: String = ""

    val processed: String = """
       |    <div id="wrapper">
                    $generalSection
                    $jobHistory
                    $educationHistory
                    $skillSection
                    $booksSection
       |        <div class="menu__wrapper">
       |            <div class="menu__wrapper_fake_contents">
       |                <menu id="menu">
       |                    <li class="menu__item"><a href="#">В начало</a></li>
       |                    <li class="menu__item"><a href="#job_history">История работы</a></li>
       |                    <li class="menu__item"><a href="#education_history">Образование</a></li>
       |                    <li class="menu__item"><a href="#skills">Навыки</a></li>
       |                    <li class="menu__item"><a href="#books_read">Книги</a></li>
       |                </menu>
       |            </div>
       |        </div>
       |        <div id="photo_enlarger__white_background" class="photo_enlarger__hidden"><img src="" id="photo_enlarger__photo"></div>
       |    </div>
    """.trim()
}
