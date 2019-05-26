package com.madhax.trakker.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Project(
        @Id
        var id: String?,
        var name: String?,
        var description: String?,
        @DBRef
        var owner: User?,
        @DBRef
        val tickets: List<Ticket>? = null)
