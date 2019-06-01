package com.madhax.trakker.repository

import com.madhax.trakker.model.Blocker
import org.springframework.data.repository.CrudRepository

interface BlockerRepository  : CrudRepository<Blocker, Long> {
}