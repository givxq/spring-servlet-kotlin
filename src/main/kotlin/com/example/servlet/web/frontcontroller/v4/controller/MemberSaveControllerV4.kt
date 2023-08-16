package com.example.servlet.web.frontcontroller.v4.controller

import com.example.servlet.domain.member.Member
import com.example.servlet.domain.member.MemberRepository
import com.example.servlet.web.frontcontroller.v4.ControllerV4

class MemberSaveControllerV4 : ControllerV4 {
    val memberRepository = MemberRepository

    override fun process(paramMap: MutableMap<String, String>, model: MutableMap<String, Any>): String {
        val username = paramMap["username"].toString()
        val age = paramMap["age"].toString().toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        model["member"] = member
        return "save-result"
    }
}