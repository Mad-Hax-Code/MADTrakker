package com.madhax.trakker.model


import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Blocker(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var message: String?,
        var dateCreated: LocalDateTime?,
        @OneToOne
        var ticket: Ticket?,
        @OneToOne
        var creator: User?)
