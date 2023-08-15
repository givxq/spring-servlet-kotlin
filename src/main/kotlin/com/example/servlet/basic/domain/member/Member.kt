package com.example.servlet.basic.domain.member

data class Member(
    var id: Long,
    val username: String = "",
    val age: Int = 0,
) {
}