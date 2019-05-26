package com.madhax.trakker.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Ticket(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Long?,
        private var name: String?,
        private var description: String?,
        private var priority: Priority?,
        private var dateCreated: LocalDateTime?,
        @OneToMany
        private var tasks: List<Task>?,
        @OneToMany
        private var notes: List<Note>?,
        @OneToMany
        private var blockers: List<Blocker>?,
        @OneToOne
        private var creator: User?)
