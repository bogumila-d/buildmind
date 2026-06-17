package com.example.webpage.db

import com.example.webpage.models.Page
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PageRepository : MongoRepository<Page, String> {
    fun findByTitle(title: String): Page?
}
