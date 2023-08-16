package com.example.servlet.web.frontcontroller.v3

import com.example.servlet.web.frontcontroller.MyView
import com.example.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3
import com.example.servlet.web.frontcontroller.v3.controller.MemberListControllerV3
import com.example.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV3", urlPatterns = ["/front-controller/v3/*"])
class FrontControllerServletV3 : HttpServlet() {

    private val controllerMap: MutableMap<String, ControllerV3> = mutableMapOf()

    init {
        controllerMap["/front-controller/v3/members/new-form"] = MemberFormControllerV3()
        controllerMap["/front-controller/v3/members/save"] = MemberSaveControllerV3()
        controllerMap["/front-controller/v3/members"] = MemberListControllerV3()
    }

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("FrontControllerServletV3.service")

        val requestURI = request.requestURI

        println("requestURI = $requestURI")

        val controller = controllerMap[requestURI]

        if (controller == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        //paramMap
        val paramMap: MutableMap<String, Any> = createParamMap(request)

        val mv = controller.process(paramMap)

        val viewName = mv.viewName
        val view = viewResolver(viewName)

        view.render(mv.model, request, response)
    }

    private fun viewResolver(viewName: String) = MyView("/WEB-INF/views/$viewName.jsp")

    private fun createParamMap(request: HttpServletRequest): MutableMap<String, Any> {
        val paramMap: MutableMap<String, Any> = mutableMapOf()
        request.parameterNames.asIterator()
            .forEachRemaining { paramName ->
                paramMap[paramName] = request.getParameter(paramName)
            }
        return paramMap
    }
}
