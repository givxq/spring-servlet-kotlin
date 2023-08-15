package com.example.servlet.basic.request

import com.example.servlet.basic.HelloData
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

@WebServlet(name = "requestBodyServlet", urlPatterns = ["/request-body-json"])
class RequestBodyJsonServlet : HttpServlet() {

    private val objectMapper = ObjectMapper()

    override fun service(requset: HttpServletRequest, response: HttpServletResponse) {
        val inputStream = requset.inputStream
        val messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)

        println("messageBody = $messageBody")

        val helloData = objectMapper.readValue(messageBody, HelloData::class.java)
        println("helloData = $helloData")
    }
}