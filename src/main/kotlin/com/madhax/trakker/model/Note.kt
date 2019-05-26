package com.madhax.trakker.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Note(
        @Id
        var id: String?,
        var body: String?,
        var ticket: Ticket?,
        var dateCreated: LocalDateTime?,
        var creator: User?)
