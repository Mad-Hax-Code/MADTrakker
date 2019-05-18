package com.madhax.trakker.service

import com.madhax.trakker.model.User
import com.madhax.trakker.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(
        private val userRepository: UserRepository
) {

    fun getAll(): Flux<User> {
        return userRepository.findAll()
    }

    fun save(user: User): Mono<User> {
        return userRepository.save(user)
    }
}
