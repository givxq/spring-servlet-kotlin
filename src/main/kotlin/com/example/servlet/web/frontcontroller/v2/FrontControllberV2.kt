package com.example.servlet.web.frontcontroller.v2

import com.example.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2
import com.example.servlet.web.frontcontroller.v2.controller.MemberListControllerV2
import com.example.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV2", urlPatterns = ["/front-controller/v2/*"])
class FrontControllerServletV2 : HttpServlet() {

    private val controllerMap: MutableMap<String, ControllerV2> = mutableMapOf()

    init {
        controllerMap["/front-controller/v2/members/new-form"] = MemberFormControllerV2()
        controllerMap["/front-controller/v2/members/save"] = MemberSaveControllerV2()
        controllerMap["/front-controller/v2/members"] = MemberListControllerV2()
    }

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("FrontControllerServletV2.service")

        val requestURI = request.requestURI

        println("requestURI = $requestURI")

        val controller = controllerMap[requestURI]

        if (controller == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        controller.process(request, response)
    }
}
