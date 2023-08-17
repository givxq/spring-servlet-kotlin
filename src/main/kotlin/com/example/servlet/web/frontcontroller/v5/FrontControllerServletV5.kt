package com.example.servlet.web.frontcontroller.v5

import com.example.servlet.web.frontcontroller.MyView
import com.example.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3
import com.example.servlet.web.frontcontroller.v3.controller.MemberListControllerV3
import com.example.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3
import com.example.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV5", urlPatterns = ["/front-controller/v5/*"])
class FrontControllerServletV5 : HttpServlet() {
    private val handlerMappingMap: MutableMap<String, Any> = mutableMapOf()
    private val handlerAdapters: MutableList<MyHandlerAdapter> = mutableListOf()

    init {
        initHandlerMapping()
        initHandlerAdapters()
    }

    private fun initHandlerMapping() {
        handlerMappingMap["/front-controller/v5/v3/members/new-form"] = MemberFormControllerV3()
        handlerMappingMap["/front-controller/v5/v3/members/save"] = MemberSaveControllerV3()
        handlerMappingMap["/front-controller/v5/v3/members"] = MemberListControllerV3()
    }

    private fun initHandlerAdapters() {
        handlerAdapters.add(ControllerV3HandlerAdapter())
    }

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val handler = getHandler(request)

        if (handler == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val adapter: MyHandlerAdapter = getHandlerAdapter(handler)
        val mv = adapter.handle(request, response, handler)

        val viewName = mv.viewName
        val view = viewResolver(viewName)

        view.render(mv.model, request, response)
    }
    private fun viewResolver(viewName: String) = MyView("/WEB-INF/views/$viewName.jsp")

    private fun getHandlerAdapter(handler: Any): MyHandlerAdapter {
        for (adapter in handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter
            }
        }
        throw IllegalArgumentException("handler adapter를 찾을수 없습니다. handler=$handler")
    }

    private fun getHandler(request: HttpServletRequest): Any? {
        val requestURI = request.requestURI
        return handlerMappingMap[requestURI]
    }
}