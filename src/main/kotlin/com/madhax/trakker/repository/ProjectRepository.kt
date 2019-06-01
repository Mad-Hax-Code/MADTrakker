package com.madhax.trakker.repository

import com.madhax.trakker.model.Project
import org.springframework.data.repository.CrudRepository

interface ProjectRepository : CrudRepository<Project, Long> {
}