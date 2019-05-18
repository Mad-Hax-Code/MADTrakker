package com.madhax.trakker.repository

import com.madhax.trakker.model.User
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveCrudRepository<User, Long> {
}
