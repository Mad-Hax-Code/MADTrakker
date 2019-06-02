package com.madhax.trakker.service

import com.madhax.trakker.model.Blocker
import com.madhax.trakker.repository.BlockerRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.anyLong
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import java.util.*

@ExtendWith(SpringExtension::class)
internal class BlockerServiceTest {

    val KNOWN_ID: Long = 1L
    val KNOWN_MESSAGE = "Known message"

    @Mock
    lateinit var blockerRepository: BlockerRepository

    @InjectMocks
    lateinit var blockerService: BlockerService

    lateinit var blocker: Blocker
    lateinit var blockerList: List<Blocker>

    @BeforeEach
    fun setUp() {

        blocker = Blocker(
                id = KNOWN_ID,
                message = KNOWN_MESSAGE,
                dateCreated = LocalDateTime.now(),
                ticket = null,
                creator = null)

        blockerList = Arrays.asList(
                blocker,
                Blocker(
                        id = 2L,
                        message = "Message for blocker 2",
                        dateCreated = LocalDateTime.now(),
                        ticket = null,
                        creator = null),
                Blocker(
                        id = 3L,
                        message = "Message for blocker 3",
                        dateCreated = LocalDateTime.now(),
                        ticket = null,
                        creator = null)
        )

    }

    @Test
    fun getAll() {

        given(blockerRepository.findAll()).willReturn(blockerList)

        val returnedBlockers: List<Blocker> = blockerService.getAll()

        assertEquals(3, returnedBlockers.size)

        verify(blockerRepository, times(1)).findAll()
    }

    @Test
    fun getById() {

        given(blockerRepository.findById(anyLong())).willReturn(Optional.of(blocker))

        val returnedBlocker: Blocker = blockerService.getById(KNOWN_ID)

        assertEquals(KNOWN_ID, returnedBlocker.id)
        assertEquals(KNOWN_MESSAGE, returnedBlocker.message)

        verify(blockerRepository, times(1)).findById(ArgumentMatchers.anyLong())
    }

    @Test
    fun save() {

        given(blockerRepository.save(any(Blocker::class.java))).willReturn(blocker)

        val savedBlocker = blockerService.save(blocker)

        assertEquals(KNOWN_ID, savedBlocker.id)
        assertEquals(KNOWN_MESSAGE, savedBlocker.message)

        verify(blockerRepository, times(1)).save(any(Blocker::class.java))
    }

    @Test
    fun deleteById() {

        blockerService.deleteById(KNOWN_ID)
        verify(blockerRepository, times(1)).deleteById(ArgumentMatchers.anyLong())
    }
}
