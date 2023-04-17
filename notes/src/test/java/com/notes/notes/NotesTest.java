package com.notes.notes;

import com.notes.model.Note;
import com.notes.service.NoteService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
public class NotesTest {

    private final NoteService noteService;

    private static final Logger LOGGER = LoggerFactory.getLogger(NotesTest.class);

    @Autowired
    public NotesTest(NoteService noteService) {
        this.noteService = noteService;
    }

    @Test
    void contextLoads(){}

    @Test
    public void saveNote(){
        Note note = Note.builder()
                .noteTitle("note delete")
                .noteContent("this is a demo content")
                .dateCreated(LocalDate.now())
                .priority(Note.NotePriority.HIGH)
                .build();
        noteService.insertNote(note);
    }

    @Test
    public void getAllNotes(){
        LOGGER.info("Notes : "+noteService.getAllNotes());
    }

    @Test
    public void testGetNoteById(){
        LOGGER.info("Note:[1]->"+noteService.getNoteById(1l));
    }

    @Test
    public void testGetNoteByTitle(){
        LOGGER.info("Note:"+noteService.getNoteByTitle("note title"));
    }

    @Test
    public void testGetNoteByTitleContains(){
        LOGGER.info("Notes:"+noteService.getNoteTitleContains("note"));
    }

    @Test
    public void getAllDayNotes(){
        LOGGER.info("Notes:"+noteService.getDayNotes(LocalDate.now()));
    }

    @Test
    public void testUpdateNote(){
        Note note = noteService.getNoteTitleContains("note").get(0);
        note.setNoteContent("this is an updated content");
        LOGGER.info("Updated:"+noteService.updateNote(note));
    }

    @Test
    public void testDeleteNote(){
        Note note = noteService.getNoteTitleContains("note").get(0);
        noteService.deleteNote(note.getId());
    }

    @Test
    public void testDeleteNoteByTitle(){
        noteService.deleteNoteByTitle("note delete");
    }
}
