package com.example.webpage

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
class HomeController {

    @GetMapping("/")
    fun home(model: Model): String {
        val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        model.addAttribute("currentTime", currentTime)
        return "index"
    }

    @GetMapping("/hello")
    fun hello(model: Model): String {
        model.addAttribute("message", "Hello from Thymeleaf!")
        return "hello"
    }
}
