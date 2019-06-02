package com.madhax.trakker.service

import com.madhax.trakker.model.Project
import com.madhax.trakker.repository.ProjectRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
internal class ProjectServiceTest {

    val log: Logger = LoggerFactory.getLogger(ProjectServiceTest::class.java)
    val KNOWN_ID: Long = 1
    val KNOWN_NAME = "Trakker"

    @Mock
    lateinit var projectRepository: ProjectRepository

    @InjectMocks
    lateinit var projectService: ProjectService

    lateinit var project: Project
    lateinit var projectList: List<Project>

    @BeforeEach
    fun setUp() {
        this.project = Project(
                id = KNOWN_ID,
                name = KNOWN_NAME,
                description = "Project tracking software",
                owner = null,
                tickets = null)
        this.projectList = Arrays.asList(
                this.project,
                Project(
                        id = 2L,
                        name = "Project Two",
                        description = "Project two description",
                        owner = null,
                        tickets = null),
                Project(
                        id = 3L,
                        name = "Project Three",
                        description = "Project three description",
                        owner = null,
                        tickets = null)
        )
    }

    @Test
    fun getAll() {

        given(projectRepository.findAll()).willReturn(this.projectList)

        var returnedProjects: List<Project> = projectRepository.findAll().toList()

        assertEquals(3, returnedProjects.size)
        verify(projectRepository, times(1)).findAll()
    }

    @Test
    fun getById() {

        given(projectRepository.findById(anyLong())).willReturn(Optional.of(project))
        var returnedProject = projectService.getById(KNOWN_ID)

        assertEquals(project, returnedProject)
        assertEquals(project.name, returnedProject.name)
    }

    @Test
    fun save() {

        given(projectRepository.save(any(Project::class.java))).willReturn(this.project)
        var savedProject = projectService.save(this.project)

        assertTrue(savedProject.name.equals("Trakker"))
        verify(projectRepository, times(1)).save(any(Project::class.java))
    }

    @Test
    fun deleteById() {
        projectService.deleteById(KNOWN_ID)
        verify(projectRepository, times(1)).deleteById(ArgumentMatchers.anyLong())
    }
}
