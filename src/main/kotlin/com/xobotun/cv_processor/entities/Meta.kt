package com.xobotun.cv_processor.entities

/**
 * Some information about what the shown webpage is.
 */
data class Meta(
    val title:          String,
    val lang:           String,
    val localization:   Map<String, String>,
    val languages:      List<Lang>
)

data class Lang(
    val code:           String,
    val name:           String
)
