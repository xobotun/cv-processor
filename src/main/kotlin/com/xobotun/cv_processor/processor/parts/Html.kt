package com.xobotun.cv_processor.processor.parts

import com.xobotun.cv_processor.entities.CV

class Html(val cv: CV) {
    val bodyContent = BodyContent(cv).processed

    val processed: String = """
       |<!DOCTYPE html>
       |<html lang="${cv.meta.lang}">
       |    <head>
       |        <title>${cv.meta.title}</title>
       |        <meta charset="UTF-8">
       |        <meta name="yandex-verification" content="02857c5790ebd962">
       |        <link href="https://cv.xobotun.com/css/stylesheet.css" rel="stylesheet">
       |        <link href="https://cv.xobotun.com/css/photo_enlarger.css" rel="stylesheet">
       |        <script async src="https://cv.xobotun.com/js/photo_enlarger.js"></script>
       |        <script async src="https://cv.xobotun.com/js/spoiler_expander.js"></script>
       |    </head>
       |    <body>
               $bodyContent
       |    </body>
       |</html>
    """.trimMargin()
}
