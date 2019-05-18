package com.madhax.trakker.bootstrap

import com.madhax.trakker.model.User
import com.madhax.trakker.repository.UserRepository
import com.madhax.trakker.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Bootstrap : CommandLineRunner {

//    private val log: Logger = LoggerFactory.getLogger(Bootstrap::class.java)
//    private val userService: UserService
//
//    @Autowired
//    constructor(userService: UserService) {
//        this.userService = userService
//    }


    override fun run(vararg args: String?) {
//        init()
        println("ASFDASDF##########################################")
    }

//    fun init() {
//        log.debug("Initializing Bootstrap")
//        var user: User = User(null, "John", "Doe", "jdoe", "pass", "jdoe@gmail.com", false)
//
//        userService.save(user)
//    }
}
