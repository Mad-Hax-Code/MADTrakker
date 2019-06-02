package com.madhax.trakker.repository

import com.madhax.trakker.model.Project
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository : CrudRepository<Project, Long> {
}
