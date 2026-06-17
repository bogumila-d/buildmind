package com.example.webpage.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "pages")
data class Page(
    @Id
    val id: String? = null,
    val title: String,
    val content: String,
    val createdAt: Long = System.currentTimeMillis()
)

