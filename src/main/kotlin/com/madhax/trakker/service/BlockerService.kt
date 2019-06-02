package com.madhax.trakker.service

import com.madhax.trakker.model.Blocker
import com.madhax.trakker.repository.BlockerRepository
import org.springframework.beans.factory.annotation.Autowired

class BlockerService(
        @Autowired
        val blockerRepository: BlockerRepository
) {

    fun getAll() : List<Blocker> {
        return blockerRepository!!.findAll().toList()
    }

}
