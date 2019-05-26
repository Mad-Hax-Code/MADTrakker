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
        var id: Long,
        var firstName: String,
        var lastName: String,
        var userName: String,
        @JsonIgnore
        var password: String,
        var email: String,
        var enabled: Boolean)
