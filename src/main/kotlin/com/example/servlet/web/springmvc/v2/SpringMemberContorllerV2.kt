package com.example.servlet.web.springmvc.v2

import com.example.servlet.domain.member.Member
import com.example.servlet.domain.member.MemberRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/springmvc/v2/members")
class SpringMemberContorllerV2 {
    val memberRepository = MemberRepository

    @RequestMapping("/new-form")
    fun newForm() : ModelAndView = ModelAndView("new-form")

    @RequestMapping("save")
    fun members(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val username = request.getParameter("username").toString()
        val age = request.getParameter("age").toString().toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        val mv = ModelAndView("save-result")
        mv.addObject("member", member)
        return mv
    }

    @RequestMapping
    fun members(paramMap: MutableMap<String, Any>): ModelAndView {
        val members = memberRepository.findAll()
        val mv = ModelAndView("members")
        mv.addObject("members", members)

        return mv
    }
}