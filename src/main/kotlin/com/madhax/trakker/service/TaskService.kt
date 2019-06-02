package com.madhax.trakker.service

import com.madhax.trakker.model.Task
import com.madhax.trakker.repository.TaskRepository
import jdk.jshell.spi.ExecutionControl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService(
        @Autowired
        private val taskRepository: TaskRepository
) {

    private val log: Logger = LoggerFactory.getLogger(TaskService::class.java)

    fun getAll(): List<Task> {
        log.debug("Getting all tasks...")
        return taskRepository.findAll().toList()
    }

    fun getById(id: Long): Task {
        log.debug("Getting task with id $id")
        return taskRepository.findById(id).get()
    }

    fun save(task: Task): Task {
        val savedTask = taskRepository.save(task)
        log.debug("Saved task id ${savedTask.id}")
        return savedTask
    }

    fun deleteById(id: Long) {
        taskRepository.deleteById(id)
    }
}
