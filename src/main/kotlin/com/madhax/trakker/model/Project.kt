package com.madhax.trakker.model

import org.springframework.data.annotation.Id
import javax.persistence.*

@Entity
data class Project(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: String?,
        var name: String?,
        var description: String?,
        @OneToOne
        var owner: User?,
        @OneToMany
        val tickets: List<Ticket>? = null)
