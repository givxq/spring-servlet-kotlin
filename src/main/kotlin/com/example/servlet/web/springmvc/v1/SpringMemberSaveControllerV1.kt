package com.example.servlet.web.springmvc.v1

import com.example.servlet.domain.member.Member
import com.example.servlet.domain.member.MemberRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class SpringMemberSaveControllerV1 {
    val memberRepository = MemberRepository

    @RequestMapping("/springmvc/v1/members/save")
    fun process(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val username = request.getParameter("username").toString()
        val age = request.getParameter("age").toString().toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        val mv = ModelAndView("save-result")
//        mv.model["member"] = member
        mv.addObject("member", member)
        return mv
    }
}