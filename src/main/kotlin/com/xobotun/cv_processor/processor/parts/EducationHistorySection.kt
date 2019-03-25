package com.xobotun.cv_processor.processor.parts

import com.xobotun.cv_processor.entities.CV
import com.xobotun.cv_processor.entities.EducationHistory
import com.xobotun.cv_processor.entities.JobHistory
import com.xobotun.cv_processor.util.getHumanReadableLocalDate
import com.xobotun.cv_processor.util.getHumanReadableTimeSpan

class EducationHistorySection(val cv: CV) {
    val educations: String = Educations(cv).processed

    val processed: String = """
       |        <section class="section">
       |            <header id="education_history" class="section__header">${cv.meta.localization["education_history"]}</header>
                    $educations
       |        </section>
    """.trim()
}

class Educations(val cv: CV) {
    val processed: String by lazy {
        var result = "";
        for (education in cv.educationHistory) {
            result += getEducation(cv, education) + '\n';
        }
        return@lazy result;
    }

    private fun getEducation(cv: CV, education: EducationHistory) = """
       |                <div class="section__contents">
       |                    <header class="entry__header">
       |                        <span class="entry__header_qualification">${education.name}</span>
       |                        <span class="entry__header_qualification">${education.where}</span>
       |                        <br/>
       |                        <time title="${cv.meta.localization["from_date"]} ${getHumanReadableLocalDate(education.began)} ${cv.meta.localization["to_date"]} ${getHumanReadableLocalDate(education.ended)}" class="anything__that_has_title_attribute">${getHumanReadableTimeSpan(education.began, education.ended)}</time>
       |                        ${if (education.proofUrl != null) "<a href=\"${education.proofUrl}\" class=\"entry__header_undertext\">${cv.meta.localization["proof"]}</a>" else ""}
       |                    </header>
       |                    ${education.description}
       |                    <br/>${education.photoUrls.joinToString("") {"\n" +
       "                                       <img src=\"$it\" class=\"section__photo\"/>"}}
       |                </div>
""".trimIndent()
}
