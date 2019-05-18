package com.madhax.trakker.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Blocker(var message: String?, @OneToOne var ticket: Ticket?, @OneToOne var creator: User?, var dateCreated: LocalDateTime?) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}