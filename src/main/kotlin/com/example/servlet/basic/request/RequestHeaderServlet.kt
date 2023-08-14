package com.example.servlet.basic.request

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "requestHeaderServlet", urlPatterns = ["/request-header"])
class RequestHeaderServlet : HttpServlet(){
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        printStartLine(request)
        printHeaders(request)
    }

    private fun printStartLine(request: HttpServletRequest) {
        println("--- REQUEST-LINE - start ---")
        println("request.getMethod() = " + request.method) //GET
        println("request.getProtocol() = " + request.protocol) // HTTP/1.1
        println("request.getScheme() = " + request.scheme) //http
        // http://localhost:8080/request-header
        println("request.getRequestURL() = " + request.requestURL)
        // /request-header
        println("request.getRequestURI() = " + request.requestURI)
        //username=hi
        println(
            "request.getQueryString() = " +
                    request.queryString
        )
        println("request.isSecure() = " + request.isSecure) //https 사용 유무
        println("--- REQUEST-LINE - end ---")
        println()
    }

    private fun printHeaders(request: HttpServletRequest) {
        println("--- Headers - start ---")

//        val headerNames = request.headerNames
//        while (headerNames.hasMoreElements()) {
//            val headerName = headerNames.nextElement()
//            println("headerName = $headerName")
//        }

        request.headerNames.asIterator()
            .forEachRemaining{ println("headerName: $it") }

        println("--- Header - end ---")
    }
}