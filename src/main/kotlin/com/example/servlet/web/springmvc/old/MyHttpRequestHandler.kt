package com.example.servlet.web.springmvc.old

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.HttpRequestHandler

@Component("/spring/request-handler")
class MyHttpRequestHandler : HttpRequestHandler {
    override fun handleRequest(request: HttpServletRequest, response: HttpServletResponse) {
        println("MyHttpRequestHandler.handleRequest")
    }
}