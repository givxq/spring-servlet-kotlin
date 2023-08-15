package com.example.servlet.basic.domain.member

import kotlin.properties.Delegates

data class Member(
    val username: String = "",
    val age: Int = 0,
) {
    var id by Delegates.notNull<Long>()
}