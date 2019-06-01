package com.madhax.trakker.model


import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Blocker(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Long?,
        private var message: String?,
        private var dateCreated: LocalDateTime?,
        @OneToOne
        private var ticket: Ticket?,
        @OneToOne
        private var creator: User?)
