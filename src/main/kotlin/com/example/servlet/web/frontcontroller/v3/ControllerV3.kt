package com.example.servlet.web.frontcontroller.v3

import com.example.servlet.web.frontcontroller.ModelView

interface ControllerV3 {
    fun process(paramMap: MutableMap<String, Any>): ModelView
}