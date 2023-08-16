package com.example.servlet.web.frontcontroller.v4.controller

import com.example.servlet.domain.member.MemberRepository
import com.example.servlet.web.frontcontroller.v4.ControllerV4

class MemberListControllerV4 : ControllerV4{
    val memberRepository = MemberRepository
    override fun process(paramMap: MutableMap<String, String>, model: MutableMap<String, Any>): String {
        val members = memberRepository.findAll()
        model["members"] = members

        return "members"
    }
}