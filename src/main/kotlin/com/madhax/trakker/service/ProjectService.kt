package com.madhax.trakker.service

import com.madhax.trakker.model.Project
import com.madhax.trakker.repository.ProjectRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProjectService(
        @Autowired
        private val projectRepository: ProjectRepository
) {
    private val log: Logger = LoggerFactory.getLogger(ProjectService::class.java)

    fun getAll(): List<Project> {
        log.debug("Getting list of all projects...")
        return projectRepository.findAll().toList()
    }

    fun getById(id: Long): Project {
        log.debug("Getting project with id: {}", id)
        return projectRepository.findById(id).get()
    }

    fun save(project: Project): Project {
        val savedProject: Project = this.projectRepository.save(project)
        log.debug("Project saved: ${savedProject.name}")
        return savedProject
    }

    fun deleteById(id: Long) {
        log.debug("Deleting record with id: {}", id)
        this.projectRepository.deleteById(id)
    }
}
