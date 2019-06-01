package com.madhax.trakker.repository

import com.madhax.trakker.model.Task
import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<Task, Long> {
}