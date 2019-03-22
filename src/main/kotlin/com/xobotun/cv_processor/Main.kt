package com.xobotun.cv_processor

import com.fasterxml.jackson.module.kotlin.readValue
import com.xobotun.cv_processor.entities.CV
import com.xobotun.cv_processor.processor.Processor
import com.xobotun.cv_processor.util.getObjectMapper
import com.xobotun.cv_processor.util.splitCvName
import java.io.File

fun main(args: Array<String>) {
    args.forEach {
        val (name, lang) = splitCvName(it)
        val cv: CV = getObjectMapper().readValue(File(it));

        File("${name}_${cv.meta.lang}_compiled.html").writeText(Processor(cv).processed);
    }
}
