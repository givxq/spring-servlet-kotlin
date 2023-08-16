package com.example.servlet.web.frontcontroller.v4

interface ControllerV4 {
    /**
     * Process
     *
     * @param paramMap
     * @param model
     * @return viewName
     */
    fun process(paramMap: MutableMap<String, String>, model: MutableMap<String, Any>) : String
}