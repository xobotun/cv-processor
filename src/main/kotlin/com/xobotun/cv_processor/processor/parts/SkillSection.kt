package com.xobotun.cv_processor.processor.parts

import com.xobotun.cv_processor.entities.CV
import com.xobotun.cv_processor.entities.SkillSection
import com.xobotun.cv_processor.entities.SkillSet
import com.xobotun.cv_processor.entities.Subskill

class SkillSection(val cv: CV) {
    val skills: String = Skills(cv).processed

    val processed: String = """
       |        <section class="section">
       |            <header id="job_history" class="section__header">${cv.meta.localization["skills"]}</header>
$skills
       |        </section>
    """.trim()
}

class Skills(val cv: CV) {
    val processed: String by lazy {
        var result = "";
        for (skill in cv.skills) {
            result += getSkill(skill) + '\n';
        }
        return@lazy result;
    }

    private fun getSkill(skill: SkillSection) : String {
        val skillsets = skill.skillsets.map { getSkillset(cv, it) }.joinToString("\n")

        return """
       |               <div class="section__contents">
       |                    <header class="entry__header">
       |                        <span title="${skill.description}" class="entry__header_qualification anything__that_has_title_attribute">${skill.name}</span>
       |                    </header>
$skillsets
       |               </div>
""".trimIndent()
    }

    private fun getSkillset(cv: CV, skillset: SkillSet) : String {
        var subskills = skillset.subskills.map { getSubskill(cv, it) }.joinToString("\n")
        if (!subskills.isBlank())
            subskills = """
       |                        <a href="javascript:;" class="entry__header_undertext link_that_leads_to_the_same_page">${cv.meta.localization["moar"]}</a>
       |                        <div class="spoiler spoiler__hidden">
$subskills
       |                        </div>"""

        return """
       |                    <div class="skill_list__item">
       |                        <span class="skill_list__item__header">${skillset.name}</span>
       |                        <div class="percentage_bar">
       |                            <div class="percentage_bar__filling" style="width: ${skillset.level}%;"></div>
       |                        </div>
       |                        <br/>
       |                        <time class="entry__header_undertext entry__header_undertext_prefer_fixed_width">${skillset.experience}</time>
$subskills
       |                    </div>
""".trimIndent()
    }

    private fun getSubskill(cv: CV, subskill: Subskill) = """
       |                            <div class="skill_list__subskills_list_item"><span class="subskill__name">${subskill.name}</span>
       |                                <div class="percentage_bar percentage_bar_subskill">
       |                                    <div class="percentage_bar__filling" style="width: ${subskill.level}%;"></div>
       |                                </div>
       |                            </div>
""".trimIndent()

}
