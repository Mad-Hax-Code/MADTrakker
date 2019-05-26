package com.madhax.trakker.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Blocker(
        @Id
        private var id: String? = null,
        private var message: String?,
        private var ticket: Ticket?,
        private var creator: User?,
        private var dateCreated: LocalDateTime?)
