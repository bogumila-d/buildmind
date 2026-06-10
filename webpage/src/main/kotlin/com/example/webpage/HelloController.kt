package com.example.webpage

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/")
    fun index(): String {
        return "Hello World from Spring Boot with Kotlin!"
    }

    @GetMapping("/health")
    fun health(): Map<String, String> {
        return mapOf("status" to "UP")
    }
}
