package com.example.servlet.web.frontcontroller.v3.controller

import com.example.servlet.web.frontcontroller.ModelView
import com.example.servlet.web.frontcontroller.v3.ControllerV3

class MemberFormControllerV3 : ControllerV3{
    override fun process(paramMap: MutableMap<String, Any>): ModelView {
        return ModelView("new-form")
    }
}