package com.example

import com.example.plugins.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty

fun main() {
    embeddedServer(Jetty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    with(dummyMehtod("some") {
        println(it)
    }) {
        println(this)
    } ?: ""
    configureRouting()
}

fun dummyMehtod(value: String, ff: (String) -> Unit) {
    println(value)
}
