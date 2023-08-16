package com.example.servlet.web.frontcontroller.v2.controller

import com.example.servlet.domain.member.Member
import com.example.servlet.domain.member.MemberRepository
import com.example.servlet.web.frontcontroller.MyView
import com.example.servlet.web.frontcontroller.v2.ControllerV2
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberSaveControllerV2 : ControllerV2 {
    val memberRepository = MemberRepository
    override fun process(request: HttpServletRequest, response: HttpServletResponse): MyView {
        val username = request.getParameter("username")
        val age = request.getParameter("age").toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        //Model에 데이터를 보관한다.
        request.setAttribute("member", member)

        return MyView("/WEB-INF/views/save.jsp")
    }
}