package com.example.servlet.basic.request

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "requestParamServlet", urlPatterns = ["/request-param"])
class RequestParamServlet : HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
       println("RequestParamServlet.service")

        println("[전체 파라미터 조회] - start")

        request.parameterNames.asIterator()
            .forEachRemaining { println("$it = ${request.getParameter(it)}") }

        println("[전체 파라미터 조회] - end")
    }
}