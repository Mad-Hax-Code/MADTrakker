package com.madhax.trakker.service

import com.madhax.trakker.model.User
import com.madhax.trakker.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(
        @Autowired
        private val userRepository: UserRepository
) {

    private val log: Logger = LoggerFactory.getLogger(UserService::class.java)

    fun getAll(): List<User> {
        log.debug("Getting all users...")
        return userRepository.findAll().toList()
    }

    fun getById(id: Long): User {
        log.debug("Getting user with id of $id")
        return userRepository.findById(id).get()
    }

    fun save(user: User): User {
        val savedUser = userRepository.save(user)
        log.debug("Saved user with id ${user.id}")
        return savedUser
    }

    fun deleteById(id: Long) {
        userRepository.deleteById(id)
        log.debug("Deleted user with id $id")
    }
}
