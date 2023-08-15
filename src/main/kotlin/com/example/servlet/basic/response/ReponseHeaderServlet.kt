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
        response.setHeader("Content-Type", "text/plain;charset=utf-8")
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        response.setHeader("Pragma", "no-cache")
        response.setHeader("my-header", "hello")

        //[Header 편의 메서드]
        content(response)

        val writer = response.writer
        writer.println("ok")
    }

    private fun content(response: HttpServletResponse) {
        response.contentType = "text/plain"
        response.characterEncoding = "utf-8"
    }
}