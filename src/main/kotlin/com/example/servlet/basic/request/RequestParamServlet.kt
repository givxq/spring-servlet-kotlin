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

        println("[단일 파라미터 조회]")
        val username = request.getParameter("username")
        val age = request.getParameter("age")

        println("username = ${username}")
        println("age = ${age}")
        println()

        println("[이름이 같은 복수 파라미터 조회]")
        val usernames = request.getParameterValues("username")
        for (name in usernames) {
            println("name = ${name}")
        }
    }
}