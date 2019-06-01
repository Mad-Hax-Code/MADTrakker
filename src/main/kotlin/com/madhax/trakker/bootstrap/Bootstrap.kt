package com.madhax.trakker.bootstrap

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Bootstrap : CommandLineRunner {

    val log: Logger = LoggerFactory.getLogger(Bootstrap::class.java)

    override fun run(vararg args: String?) {
        log.debug("I am Bootstrap")
    }

}
