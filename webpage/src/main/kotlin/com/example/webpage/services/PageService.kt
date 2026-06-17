package com.example.webpage.services

import com.example.webpage.db.PageRepository
import com.example.webpage.models.Page
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PageService(private val pageRepository: PageRepository) {

    fun createPage(title: String, content: String): Page {
        val page = Page(
            id = UUID.randomUUID().toString(),
            title = title,
            content = content
        )
        return pageRepository.save(page)
    }

    fun getAllPages(): List<Page> {
        return pageRepository.findAll()
    }

    fun getPageByTitle(title: String): Page? {
        return pageRepository.findByTitle(title)
    }

    fun deletePageById(id: String) {
        pageRepository.deleteById(id)
    }
}
