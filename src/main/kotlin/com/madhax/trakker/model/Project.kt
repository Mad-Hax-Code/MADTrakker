package com.madhax.trakker.model

import org.springframework.data.annotation.Id
import javax.persistence.*

@Entity
data class Project(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: String?,
        private var name: String?,
        private var description: String?,
        @OneToOne
        private var owner: User?,
        @OneToMany
        private val tickets: List<Ticket>? = null)
