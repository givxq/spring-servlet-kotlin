package com.example.servlet.web.frontcontroller

class ModelView(
    val viewName: String,
) {
    val model: MutableMap<String, Any> = mutableMapOf()
}