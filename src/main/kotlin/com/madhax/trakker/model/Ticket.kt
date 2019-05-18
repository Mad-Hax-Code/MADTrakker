package com.madhax.trakker.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Ticket(var name: String?,
                  var description: String?,
                  var priority: Priority?,
                  @OneToMany var tasks: List<Task>?,
                  @OneToMany var notes: List<Note>?,
                  @OneToMany var blockers: List<Blocker>?,
                  var dateCreated: LocalDateTime?,
                  @OneToOne var creator: User?) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


}