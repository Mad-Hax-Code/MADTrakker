package com.madhax.trakker.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class User (

        @Id
        var id: Long?,
        var firstName: String,
        var lastName: String,
        var userName: String,
        @JsonIgnore
        var password: String,
        var email: String,
        var enabled: Boolean
)
