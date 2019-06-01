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
        var id: Long?,
        var body: String?,
        var dateCreated: LocalDateTime?,
        @OneToOne
        var ticket: Ticket?,
        @OneToOne
        var creator: User?)
