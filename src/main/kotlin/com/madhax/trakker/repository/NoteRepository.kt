package com.madhax.trakker.repository

import com.madhax.trakker.model.Note
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : CrudRepository<Note, Long> {
}
