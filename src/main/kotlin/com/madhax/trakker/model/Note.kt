package com.madhax.trakker.model

import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToOne

@Entity
data class Note(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: String?,
        private var body: String?,
        private var dateCreated: LocalDateTime?,
        @OneToOne
        private var ticket: Ticket?,
        @OneToOne
        private var creator: User?)
