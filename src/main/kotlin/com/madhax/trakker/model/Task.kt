package com.madhax.trakker.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var body: String?,
        var dateCreated: LocalDateTime?,
        @OneToOne
        var ticket: Ticket?,
        @OneToOne
        var creator: User?)
