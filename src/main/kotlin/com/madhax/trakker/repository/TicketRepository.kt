package com.madhax.trakker.repository

import com.madhax.trakker.model.Ticket
import org.springframework.data.repository.CrudRepository

interface TicketRepository : CrudRepository<Ticket, Long> {
}