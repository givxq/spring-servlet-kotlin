package com.example.servlet.web.frontcontroller

class ModelView(
    val viewName: String,
) {
    var model: MutableMap<String, Any> = mutableMapOf()
}