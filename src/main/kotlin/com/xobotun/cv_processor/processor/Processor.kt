package com.xobotun.cv_processor.processor

import com.xobotun.cv_processor.entities.CV
import com.xobotun.cv_processor.processor.parts.Html

class Processor(val cv: CV) {
    val processed = Html(cv).processed
}

