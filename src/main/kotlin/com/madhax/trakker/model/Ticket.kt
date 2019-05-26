package com.madhax.trakker.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Ticket(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String?,
        var description: String?,
        var priority: Priority?,
        var dateCreated: LocalDateTime?,
        @OneToMany
        var tasks: List<Task>?,
        @OneToMany
        var notes: List<Note>?,
        @OneToMany
        var blockers: List<Blocker>?,
        @OneToOne
        var creator: User?)
