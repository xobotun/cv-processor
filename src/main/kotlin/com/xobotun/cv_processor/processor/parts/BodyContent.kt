package com.xobotun.cv_processor.processor.parts

import com.xobotun.cv_processor.entities.CV

class BodyContent(val cv: CV) {
    val generalSection: String = GeneralSection(cv).processed
    val jobHistory: String = JobHistorySection(cv).processed
    val educationHistory: String = EducationHistorySection(cv).processed
    val skillSection: String = SkillSection(cv).processed
    val booksSection: String = BooksSection(cv).processed

    val processed: String = """
       |    <div id="wrapper">
                    $generalSection
                    $jobHistory
                    $educationHistory
                    $skillSection
                    $booksSection
       |
       |        <div class="menu__wrapper disappear_on_small_screen">
       |            <div class="menu__wrapper_fake_contents">
       |                <menu id="menu">
       |                    <li class="menu__item"><a href="#">${cv.meta.localization["home"]}</a></li>
       |                    <li class="menu__item"><a href="#job_history">${cv.meta.localization["job_history"]}</a></li>
       |                    <li class="menu__item"><a href="#education_history">${cv.meta.localization["education_history"]}</a></li>
       |                    <li class="menu__item"><a href="#skills">${cv.meta.localization["skills"]}</a></li>
       |                    <li class="menu__item"><a href="#books_read">${cv.meta.localization["books_read"]}</a></li>
       |                </menu>
       |            </div>
       |        </div>
       |
       |        <div class="menu__wrapper disappear_on_small_screen">
       |            <div class="menu__wrapper_fake_contents">
       |                <!-- Flags via https://github.com/lipis/flag-icon-css -->
       |                <menu id="lang">
                            ${getLangMenu()}
       |                </menu>
       |            </div>
       |        </div>
       |
       |        <div id="photo_enlarger__white_background" class="photo_enlarger__hidden"><img src="" id="photo_enlarger__photo"></div>
       |    </div>
    """.trim()

    private fun getLangMenu() {
        cv.meta.languages.map { """
        |                    <li class="lang_menu__item"><a href="/cv_${it.code}_compiled.html"><img src="https://cv.xobotun.com/icons/flags/${it.code}.svg" alt="${it.name}"/></a></li>
        """ }
            .joinToString(separator = "\n")
    }
}
