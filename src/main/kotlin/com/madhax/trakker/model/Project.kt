package com.madhax.trakker.model

import javax.persistence.*

@Entity
data class Project(var name: String?, var description: String?, @OneToOne var owner: User?) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @OneToMany
    private val tickets: List<Ticket>? = null

}
