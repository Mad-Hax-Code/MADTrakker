package com.madhax.trakker.service

import com.madhax.trakker.model.Blocker
import com.madhax.trakker.repository.BlockerRepository

class BlockerService(
        val blockerRepository: BlockerRepository?
) {
    fun getAll() : List<Blocker> {
        return blockerRepository.findAll();
    }
}