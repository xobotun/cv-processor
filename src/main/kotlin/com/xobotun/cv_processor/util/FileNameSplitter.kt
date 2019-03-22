package com.xobotun.cv_processor.util

import java.util.regex.Pattern

data class MeaningfulName(val name: String, val language: String)

fun splitCvName(file: String): MeaningfulName {
    // get only last string after all '/' and '\'
    // and splitCvName it by '.'
    val tokens = """.*[\\/](\w+)\.(\w+)\.json$""".toRegex().findAll(file).toList()[0].groups
    assert(tokens.size == 2) {"File $file has wrong format. Make sure it is something like \"/home/blah/name.lang.json\"."}
    return MeaningfulName(tokens[1]!!.value, tokens[2]!!.value)     // group #0 is the whole file name, as it matches.
}
