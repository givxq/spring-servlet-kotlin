package com.example.servlet.web.servletmvc

import com.example.servlet.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "mcvMemberListServlet", urlPatterns = ["/servlet-mvc/members/"])
class MvcMemberListServlet : HttpServlet() {
    val memberRepository = MemberRepository
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val members = memberRepository.findAll()

        request.setAttribute("members", members)

        val viewPath = "/WEB-INF/views/members.jsp"
        val dispatcher = request.getRequestDispatcher(viewPath)
        dispatcher.forward(request, response)    }
}