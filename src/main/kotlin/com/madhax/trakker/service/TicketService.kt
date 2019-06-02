package com.madhax.trakker.service

import com.madhax.trakker.model.Ticket
import com.madhax.trakker.repository.TicketRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TicketService(
        @Autowired
        private val ticketRepository: TicketRepository
) {

    private val log: Logger = LoggerFactory.getLogger(TicketService::class.java)

    fun getAll(): List<Ticket> {
        log.debug("Getting list of all tickets...")
        return ticketRepository.findAll().toList()
    }

    fun getById(id: Long): Ticket {
        log.debug("Getting record with id of $id")
        return ticketRepository.findById(id).get()
    }

    fun save(ticket: Ticket): Ticket {
        val savedTicket = ticketRepository.save(ticket)
        log.debug("Saved record with id of ${savedTicket.id}")
        return savedTicket
    }

    fun deleteById(id: Long) {
        ticketRepository.deleteById(id)
    }
}
