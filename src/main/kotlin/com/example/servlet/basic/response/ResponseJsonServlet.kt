package com.example.servlet.basic.response

import com.example.servlet.basic.HelloData
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "responseJsonServlet", urlPatterns = ["/response-json"])
class ResponseJsonServlet : HttpServlet() {
    private val objectMapper = ObjectMapper().registerKotlinModule()
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "application/json"
        response.characterEncoding = "utf-8"

        val helloData = HelloData("kim", 20)

        val result = objectMapper.writeValueAsString(helloData)
        response.writer.write(result)
    }
}