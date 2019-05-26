package com.madhax.trakker.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Long?,
        private var body: String?,
        private var dateCreated: LocalDateTime?,
        @OneToOne
        private var ticket: Ticket?,
        @OneToOne
        private var creator: User?)
