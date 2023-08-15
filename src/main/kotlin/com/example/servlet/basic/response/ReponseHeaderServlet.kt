package com.example.servlet.basic.response

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "responseHeaderServlet", urlPatterns = ["/response-header"])
class ReponseHeaderServlet : HttpServlet() {
    override fun service(requset: HttpServletRequest, response: HttpServletResponse) {
        //[status-line]
        response.status = HttpServletResponse.SC_OK

        //[response-header]
        response.setHeader("Content-Type", "text/plain")
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        response.setHeader("Pragma", "no-cache")
        response.setHeader("my-header", "hello")

    }
}