package com.madhax.trakker.service

import com.madhax.trakker.model.Note
import com.madhax.trakker.repository.NoteRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NoteService(
        @Autowired
        private val noteRepository: NoteRepository
) {

    private val log: Logger = LoggerFactory.getLogger(NoteService::class.java)

    fun getAll(): List<Note> {
        log.debug("Getting all notes...")
        return noteRepository.findAll().toList()
    }

    fun getById(id: Long): Note {
        log.debug("Getting note with id of: $id")
        return noteRepository.findById(id).get()
    }

    fun save(note: Note): Note {
        val savedNote = noteRepository.save(note)
        log.debug("Saved note: ${savedNote.id}")
        return savedNote
    }

    fun deleteById(id: Long) {
        log.debug("Deleting note with id of $id")
        noteRepository.deleteById(id)
    }
}
