package com.example.servlet.web.frontcontroller.v5.adapter

import com.example.servlet.web.frontcontroller.ModelView
import com.example.servlet.web.frontcontroller.v4.ControllerV4
import com.example.servlet.web.frontcontroller.v5.MyHandlerAdapter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class ControllerV4HandlerAdapter : MyHandlerAdapter {
    override fun supports(handler: Any): Boolean {
        return (handler is ControllerV4)
    }

    override fun handle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV4

        val paramMap = createParamMap(request)
        val model: MutableMap<String, Any> = mutableMapOf()

        val viewName = controller.process(paramMap, model)

        return createModelView(viewName, model)
    }

    private fun createModelView(
        viewName: String,
        model: MutableMap<String, Any>
    ): ModelView {
        val modelView = ModelView(viewName)
        modelView.model = model

        return modelView
    }

    private fun createParamMap(request: HttpServletRequest): MutableMap<String, String> {
        val paramMap: MutableMap<String, String> = mutableMapOf()
        request.parameterNames.asIterator()
            .forEachRemaining { paramName ->
                paramMap[paramName] = request.getParameter(paramName)
            }
        return paramMap
    }
}