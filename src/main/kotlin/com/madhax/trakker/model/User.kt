package com.madhax.trakker.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Long,
        private var firstName: String,
        private var lastName: String,
        private var userName: String,
        @JsonIgnore
        private var password: String,
        private var email: String,
        private var enabled: Boolean)
