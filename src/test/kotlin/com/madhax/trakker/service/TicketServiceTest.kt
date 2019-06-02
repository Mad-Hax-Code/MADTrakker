package com.madhax.trakker.service

import com.madhax.trakker.model.Priority
import com.madhax.trakker.model.Ticket
import com.madhax.trakker.repository.TicketRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import java.util.*

@ExtendWith(SpringExtension::class)
internal class TicketServiceTest {

    val KNOWN_ID: Long = 1L
    val KNOWN_NAME: String = "Known Name"
    val KNOWN_DESCRIPTION: String = "Known description"

    @Mock
    lateinit var ticketRepository: TicketRepository

    @InjectMocks
    lateinit var ticketService: TicketService

    lateinit var ticket: Ticket
    lateinit var ticketList: List<Ticket>

    @BeforeEach
    fun setUp() {

        ticket = Ticket(
                id = KNOWN_ID,
                name = KNOWN_NAME,
                description = KNOWN_DESCRIPTION,
                priority = Priority.HIGH,
                dateCreated = LocalDateTime.now(),
                tasks = null,
                notes = null,
                blockers = null,
                creator = null)

        ticketList = Arrays.asList(
                ticket,
                Ticket(
                        id = 2L,
                        name = "Ticket two name",
                        description = "Ticket two description",
                        priority = Priority.HIGH,
                        dateCreated = LocalDateTime.now(),
                        tasks = null,
                        notes = null,
                        blockers = null,
                        creator = null),
                Ticket(
                        id = 3L,
                        name = "Ticket three name",
                        description = "Ticket three description",
                        priority = Priority.HIGH,
                        dateCreated = LocalDateTime.now(),
                        tasks = null,
                        notes = null,
                        blockers = null,
                        creator = null) )
    }

    @Test
    fun getAll() {

        given(ticketRepository.findAll()).willReturn(ticketList)

        var returnedTickets: List<Ticket> = ticketService.getAll()

        assertEquals(3, returnedTickets.size)

        verify(ticketRepository, times(1)).findAll()
    }

    @Test
    fun getById() {

        given(ticketRepository.findById(anyLong())).willReturn(Optional.of(ticket))

        var returnedTicket = ticketService.getById(KNOWN_ID)

        assertEquals(KNOWN_NAME, returnedTicket.name)
        assertEquals(KNOWN_DESCRIPTION, returnedTicket.description)

        verify(ticketRepository, times(1)).findById(anyLong())
    }

    @Test
    fun save() {

        given(ticketRepository.save(any(Ticket::class.java))).willReturn(ticket)

        val savedTicket = ticketService.save(ticket)

        assertEquals(KNOWN_NAME, savedTicket.name)
        assertEquals(KNOWN_DESCRIPTION, savedTicket.description)

        verify(ticketRepository, times(1)).save(any(Ticket::class.java))
    }

    @Test
    fun deleteById() {

        ticketService.deleteById(KNOWN_ID)
        verify(ticketRepository, times(1)).deleteById(anyLong())
    }
}
