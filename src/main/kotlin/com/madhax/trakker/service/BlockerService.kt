package com.madhax.trakker.service

import com.madhax.trakker.model.Blocker
import com.madhax.trakker.repository.BlockerRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class BlockerService(
        @Autowired
        private val blockerRepository: BlockerRepository
) {

    private val log: Logger = LoggerFactory.getLogger(BlockerService::class.java)

    fun getAll() : List<Blocker> {
        log.debug("Getting all blockers...")
        return blockerRepository.findAll().toList()
    }

    fun getById(id: Long): Blocker {
        log.debug("Getting blocker by id $id")
        return blockerRepository.findById(id).get()
    }

    fun save(blocker: Blocker): Blocker {
        val savedBlocker = blockerRepository.save(blocker)
        log.debug("Saved blocker with id ${savedBlocker.id}")
        return savedBlocker
    }

    fun deleteById(id: Long) {
        log.debug("Deleting blocker with id $id")
        blockerRepository.deleteById(id)
    }

}
