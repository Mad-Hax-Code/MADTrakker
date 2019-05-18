package com.madhax.trakker.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Task(var body: String?, @OneToOne var ticket: Ticket?, var dateCreated: LocalDateTime?, @OneToOne var creator: User?) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}