package com.example.servlet.web.frontcontroller.v4

import com.example.servlet.web.frontcontroller.MyView
import com.example.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4
import com.example.servlet.web.frontcontroller.v4.controller.MemberListControllerV4
import com.example.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV4", urlPatterns = ["/front-controller/v4/*"])
class FrontControllerServletV4 : HttpServlet() {

    private val controllerMap: MutableMap<String, ControllerV4> = mutableMapOf()

    init {
        controllerMap["/front-controller/v4/members/new-form"] = MemberFormControllerV4()
        controllerMap["/front-controller/v4/members/save"] = MemberSaveControllerV4()
        controllerMap["/front-controller/v4/members"] = MemberListControllerV4()
    }

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("FrontControllerServletV4.service")

        val requestURI = request.requestURI

        println("requestURI = $requestURI")

        val controller = controllerMap[requestURI]

        if (controller == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        //paramMap
        val paramMap: MutableMap<String, String> = createParamMap(request)
        val model: MutableMap<String, Any> = mutableMapOf()
        val viewName = controller.process(paramMap, model)

        val view = viewResolver(viewName)

        view.render(model, request, response)
    }

    private fun viewResolver(viewName: String) = MyView("/WEB-INF/views/$viewName.jsp")

    private fun createParamMap(request: HttpServletRequest): MutableMap<String, String> {
        val paramMap: MutableMap<String, String> = mutableMapOf()
        request.parameterNames.asIterator()
            .forEachRemaining { paramName ->
                paramMap[paramName] = request.getParameter(paramName)
            }
        return paramMap
    }
}
