package com.madhax.trakker.repository

import com.madhax.trakker.model.User

interface UserRepository : R2dbcRepository<User, Long> {
}
