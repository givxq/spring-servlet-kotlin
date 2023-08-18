package com.example.servlet.web.springmvc.v1

import com.example.servlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class SpringMemberListControllerV1 {
    val memberRepository = MemberRepository

    @RequestMapping("/springmvc/v1/members")
    fun process(paramMap: MutableMap<String, Any>): ModelAndView {
        val members = memberRepository.findAll()
        val mv = ModelAndView("members")
//        mv.model["members"] = members
        mv.addObject("members", members)

        return mv
    }
}