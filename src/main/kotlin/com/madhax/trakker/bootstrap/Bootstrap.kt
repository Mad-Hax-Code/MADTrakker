package com.madhax.trakker.bootstrap

import com.madhax.trakker.service.ProjectService
import com.madhax.trakker.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Bootstrap(
        @Autowired
        private val userService: UserService,
        @Autowired
        private val projectService: ProjectService
) : CommandLineRunner {

    val log: Logger = LoggerFactory.getLogger(Bootstrap::class.java)

    override fun run(vararg args: String?) {
        log.debug("I am Bootstrap")
    }
}
