package com.example.servlet.web.springmvc.v3

import com.example.servlet.domain.member.Member
import com.example.servlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(("/springmvc/v3/members"))
class SpringMemberControllerV3 {
    val memberRepository = MemberRepository

    @GetMapping("/new-form")
    fun newForm() = "new-form"

    @PostMapping("save")
    fun members(
        @RequestParam("username") username: String,
        @RequestParam("age") age: Int,
        model: Model
    ): String {
        val member = Member(username, age)
        memberRepository.save(member)

        val mv = ModelAndView("save-result")
        mv.addObject("member", member)

        model.addAttribute("member", member)
        return "save-result"
    }

    @GetMapping
    fun members(model: Model): String {
        val members = memberRepository.findAll()
        model.addAttribute("members", members)

        return "members"
    }
}