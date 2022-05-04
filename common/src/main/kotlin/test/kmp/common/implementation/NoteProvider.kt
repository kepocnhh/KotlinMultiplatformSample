package test.kmp.common.implementation

import test.kmp.common.foundation.Note
import java.util.UUID

object NoteProvider {
    private val notes = (0..9).map {
        Note(text = "uuid: " + UUID.randomUUID().toString())
    }

    fun getNotes(): List<Note> {
        return notes
    }
}
