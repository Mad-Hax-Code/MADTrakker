package com.madhax.trakker.repository

import com.madhax.trakker.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long> {
}