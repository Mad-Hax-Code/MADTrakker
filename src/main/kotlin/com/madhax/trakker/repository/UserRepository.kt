package com.madhax.trakker.repository

import com.madhax.trakker.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>
