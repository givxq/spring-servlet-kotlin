package com.example.servlet.web.frontcontroller.v2.controller

import com.example.servlet.domain.member.MemberRepository
import com.example.servlet.web.frontcontroller.MyView
import com.example.servlet.web.frontcontroller.v2.ControllerV2
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberListControllerV2 : ControllerV2 {
    val memberRepository = MemberRepository
    override fun process(request: HttpServletRequest, response: HttpServletResponse): MyView {
        val members = memberRepository.findAll()
        request.setAttribute("members", members)

        return MyView("/WEB-INF/views/members.jsp")
    }
}