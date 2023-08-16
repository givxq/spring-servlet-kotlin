package com.example.servlet.web.frontcontroller.v3.controller

import com.example.servlet.domain.member.MemberRepository
import com.example.servlet.web.frontcontroller.ModelView
import com.example.servlet.web.frontcontroller.v3.ControllerV3

class MemberListControllerV3 : ControllerV3{
    val memberRepository = MemberRepository
    override fun process(paramMap: MutableMap<String, Any>): ModelView {
        val members = memberRepository.findAll()
        val mv = ModelView("members")
        mv.model["members"] = members

        return mv
    }
}