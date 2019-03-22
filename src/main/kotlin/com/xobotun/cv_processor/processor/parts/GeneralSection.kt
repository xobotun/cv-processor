package com.xobotun.cv_processor.processor.parts

import com.xobotun.cv_processor.entities.CV

class GeneralSection(val cv: CV) {
    val links: String = Links(cv).processed

    val processed: String = """
       |        <section class="section section__firefox-has-no-column-span-since-2010">
       |            <div class="section__contents_site_header">
       |                <img src="${cv.general.photoUrl}" class="bio__photo_self">
       |                <div class="bio">
       |                    <span class="bio__name">${cv.general.name}</span>
       |                    <br/>
       |                    <span class="bio__description">
       |                        ${cv.general.race}, ${cv.general.gender}, ${cv.general.age}, ${cv.general.alignment}
       |                        <br/>
       |                        ${cv.general.professions.joinToString(" / ", transform = {it.name+'('+it.level+')'})}
       |                        <br/>
       |                        ${cv.general.location}
       |                    </span>
       |                    <div class="bio__contacts">
                                $links
       |                    </div>
       |                </div>
       |            </div>
       |        </section>
    """.trim()
}

class Links(val cv: CV) {
    val processed: String by lazy {
        var result = "";
        for (link in cv.general.profiles) {
            result +=
                    """
       |                        <a href="${link.link}">
       |                            <img no-enlarger="" src="${link.img}" class="bio__contacts__icon">
       |                        </a>
""".trimIndent()
            result += '\n';
        }
        return@lazy result;
    }
}
