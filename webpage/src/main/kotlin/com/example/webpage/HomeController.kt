package com.example.webpage

import com.example.webpage.services.PageService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PathVariable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
class HomeController(
    private val pageService: PageService
) {

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

    @GetMapping("/pages")
    fun listPages(model: Model): String {
        val pages = pageService.getAllPages()
        model.addAttribute("pages", pages)
        return "pages"
    }

    @PostMapping("/pages")
    fun createPage(
        @RequestParam title: String,
        @RequestParam content: String,
        model: Model
    ): String {
        pageService.createPage(title, content)
        val pages = pageService.getAllPages()
        model.addAttribute("pages", pages)
        model.addAttribute("message", "Page created successfully!")
        return "pages"
    }

    @PostMapping("/pages/{id}/delete")
    fun deletePage(
        @PathVariable id: String,
        model: Model
    ): String {
        pageService.deletePageById(id)
        val pages = pageService.getAllPages()
        model.addAttribute("pages", pages)
        model.addAttribute("message", "Page deleted successfully!")
        return "pages"
    }

}
