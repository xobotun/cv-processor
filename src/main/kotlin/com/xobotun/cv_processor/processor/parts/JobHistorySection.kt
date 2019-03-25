package com.xobotun.cv_processor.processor.parts

import com.xobotun.cv_processor.entities.CV
import com.xobotun.cv_processor.entities.JobHistory
import com.xobotun.cv_processor.util.getHumanReadableTimeSpan
import jdk.nashorn.internal.objects.NativeArray.forEach

class JobHistorySection(val cv: CV) {
    val workplaces: String = Workplaces(cv).processed

    val processed: String = """
       |        <section class="section">
       |            <header id="job_history" class="section__header">${cv.meta.localization["job_history"]}</header>
                    $workplaces
       |        </section>
    """.trim()
}

class Workplaces(val cv: CV) {
    val processed: String by lazy {
        var result = "";
        for (workplace in cv.jobHistory) {
            result += getWorkplace(workplace) + '\n';
        }
        return@lazy result;
    }

    private fun getWorkplace(workplace: JobHistory) = """
       |                        <div class="section__contents">
       |                            <header class="entry__header">
       |                                <span class="entry__header_qualification">${workplace.name}</span>
       |                                <span title="${workplace.workplaceDescription}" class="entry__header_location anything__that_has_title_attribute">${workplace.where}</span>
       |                                <br/>
       |                                <time title="С 7 ноября 2017 по н.в." class="anything__that_has_title_attribute">${getHumanReadableTimeSpan(workplace.began, workplace.ended)}</time>
       |                            </header>
       |                            ${workplace.jobDescription}
       |                            <br/>
       |                            <span class="entry__skills_list">
       |                                ${cv.meta.localization["skills"]}
                                        ${workplace.relatedSkills.joinToString("\n") {"" +
       "                                        <span class=\"entry__skills_list__item\">$it</span>"}}
       |                            </span>
       |                        </div>
""".trimIndent()
}
