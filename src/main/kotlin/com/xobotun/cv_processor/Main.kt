package com.xobotun.cv_processor

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.xobotun.cv_processor.entities.CV
import java.io.File

fun main(args: Array<String>) {
    val cv: CV = jacksonObjectMapper().readValue(File(args[0]));

    println(cv)
}
