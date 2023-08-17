package com.example.servlet.web.frontcontroller.v5.adapter

import com.example.servlet.web.frontcontroller.ModelView
import com.example.servlet.web.frontcontroller.v3.ControllerV3
import com.example.servlet.web.frontcontroller.v5.MyHandlerAdapter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class ControllerV3HandlerAdapter : MyHandlerAdapter {
    override fun supports(handler: Any): Boolean {
        return (handler is ControllerV3)
    }

    override fun handle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV3
        val paramMap = createParamMap(request)

        return controller.process(paramMap)
    }

    private fun createParamMap(request: HttpServletRequest): MutableMap<String, Any> {
        val paramMap: MutableMap<String, Any> = mutableMapOf()
        request.parameterNames.asIterator()
            .forEachRemaining { paramName ->
                paramMap[paramName] = request.getParameter(paramName)
            }
        return paramMap
    }
}