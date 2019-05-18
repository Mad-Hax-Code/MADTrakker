package com.madhax.trakker.model

import com.fasterxml.jackson.annotation.JsonIgnore

data class User (

        var id: Long?,
        var firstName: String,
        var lastName: String,
        var userName: String,
        @JsonIgnore
        var password: String,
        var email: String,
        var enabled: Boolean
)
