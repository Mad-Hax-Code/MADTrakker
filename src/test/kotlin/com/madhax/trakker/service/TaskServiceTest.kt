package com.madhax.trakker.service

import com.madhax.trakker.model.Task
import com.madhax.trakker.repository.TaskRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import java.util.*

@ExtendWith(SpringExtension::class)
internal class TaskServiceTest {

    val KNOWN_ID: Long = 1L
    val KNOWN_BODY = "Known body"

    @Mock
    lateinit var taskRepository: TaskRepository

    @InjectMocks
    lateinit var taskService: TaskService

    lateinit var task: Task
    lateinit var taskList: List<Task>

    @BeforeEach
    fun setUp() {

        task = Task(
                id = KNOWN_ID,
                body = KNOWN_BODY,
                dateCreated = LocalDateTime.now(),
                ticket = null,
                creator = null)

        taskList = Arrays.asList(
                task,
                Task(
                        id = 2L,
                        body = "Second body",
                        dateCreated = LocalDateTime.now(),
                        ticket = null,
                        creator = null),
                Task(
                        id = 3L,
                        body = "Third body",
                        dateCreated = LocalDateTime.now(),
                        ticket = null,
                        creator = null) )
    }

    @Test
    fun getAll() {

        given(taskRepository.findAll()).willReturn(taskList)

        var returnedTasks: List<Task> = taskService.getAll()

        assertEquals(3, returnedTasks.size)

        verify(taskRepository, times(1)).findAll()
    }

    @Test
    fun getById() {

        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task))

        var returnedTask = taskService.getById(KNOWN_ID)

        assertEquals(KNOWN_BODY, returnedTask.body)

        verify(taskRepository, times(1)).findById(ArgumentMatchers.anyLong())
    }

    @Test
    fun save() {

        given(taskRepository.save(any(Task::class.java))).willReturn(task)

        var savedTask = taskService.save(task)

        assertEquals(KNOWN_BODY, savedTask.body)

        verify(taskRepository, times(1)).save(any(Task::class.java))
    }

    @Test
    fun deleteById() {

        taskService.deleteById(KNOWN_ID)
        verify(taskRepository, times(1)).deleteById(ArgumentMatchers.anyLong())
    }
}
