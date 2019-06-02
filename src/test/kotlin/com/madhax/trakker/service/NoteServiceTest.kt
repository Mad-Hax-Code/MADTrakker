package com.madhax.trakker.service

import com.madhax.trakker.model.Note
import com.madhax.trakker.repository.NoteRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import java.util.*

@ExtendWith(SpringExtension::class)
internal class NoteServiceTest {

    val KNOWN_ID: Long = 1L
    val KNOWN_BODY: String = "This is the known note"

    @Mock
    lateinit var noteRepository: NoteRepository

    @InjectMocks
    lateinit var noteService: NoteService

    lateinit var note: Note
    lateinit var noteList: List<Note>

    @BeforeEach
    fun setUp() {

        note = Note(
                id = KNOWN_ID,
                body = KNOWN_BODY,
                dateCreated = LocalDateTime.now(),
                ticket = null,
                creator = null)

        noteList = Arrays.asList(
                note,
                Note(
                        id = 2L,
                        body = "Note two body",
                        dateCreated = LocalDateTime.now(),
                        ticket = null,
                        creator = null),
                Note(
                        id = 3L,
                        body = "Note three body",
                        dateCreated = LocalDateTime.now(),
                        ticket = null,
                        creator = null) )

    }

    @Test
    fun getAll() {

        given(noteRepository.findAll()).willReturn(noteList)

        var returnedNotes: List<Note> = noteService.getAll()

        assertEquals(3, returnedNotes.size)

        verify(noteRepository, times(1)).findAll()
    }

    @Test
    fun getById() {

        given(noteRepository.findById(anyLong())).willReturn(Optional.of(note))

        var returnedNote: Note = noteService.getById(KNOWN_ID)

        assertEquals(KNOWN_ID, returnedNote.id)
        assertEquals(KNOWN_BODY, returnedNote.body)
        assertEquals(note.dateCreated, returnedNote.dateCreated)

        verify(noteRepository, times(1)).findById(anyLong())
    }

    @Test
    fun save() {

        given(noteRepository.save(any(Note::class.java))).willReturn(note)

        var savedNote = noteService.save(note)

        assertEquals(KNOWN_BODY, savedNote.body)

        verify(noteRepository, times(1)).save(any(Note::class.java))
    }

    @Test
    fun deleteById() {

        noteService.deleteById(KNOWN_ID)
        verify(noteRepository, times(1)).deleteById(anyLong())
    }
}
