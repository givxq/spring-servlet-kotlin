package com.example.servlet.web.frontcontroller.v3.controller

import com.example.servlet.domain.member.Member
import com.example.servlet.domain.member.MemberRepository
import com.example.servlet.web.frontcontroller.ModelView
import com.example.servlet.web.frontcontroller.v3.ControllerV3

class MemberSaveControllerV3 : ControllerV3 {
    val memberRepository = MemberRepository
    override fun process(paramMap: MutableMap<String, Any>): ModelView {
        val username = paramMap["username"].toString()
        val age = paramMap["age"].toString().toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        val mv = ModelView("save-result")
        mv.model["member"] = member
        return mv
    }
}