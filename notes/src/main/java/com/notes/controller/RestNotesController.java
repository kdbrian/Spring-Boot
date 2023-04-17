package com.notes.controller;

import com.notes.dto.NoteDTO;
import com.notes.model.Note;
import com.notes.service.NoteService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class RestNotesController {

    private final NoteService noteService;

    @Autowired
    public RestNotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<Note> getNoteByTitle(@RequestParam(name = "title") String title){
        return ResponseEntity.ok(noteService.getNoteByTitle(title));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Note>> getAllNotesByTitle(
            @Nullable @RequestParam(name = "shared_title") String title,
            @Nullable @RequestParam(name = "published_date") String date
    ){
//        System.out.println("title = " + title);
//        System.out.println("date = " + date);
        if(date != null && title == null)
            return ResponseEntity.ok(noteService.getDayNotes(LocalDate.parse(date)));
        else if(title != null && date == null)
            return ResponseEntity.ok(noteService.getNoteTitleContains(title));
        else
            return null;
    }
    @GetMapping("/")
    public ResponseEntity<List<Note>> fetchAllNotes(){
        return  ResponseEntity.ok(noteService.getAllNotes());
    }


    @PostMapping("/")
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        Note newNote = noteService.insertNote(note);
        return  new ResponseEntity<>(newNote, HttpStatus.CREATED);
    }

    @PatchMapping("/{note_id}")
    public ResponseEntity<Note> updateNoteById(@PathVariable(name = "note_id")String noteId,
                                               @RequestBody Note note){
        Note dbNote = noteService.getNoteById(Long.valueOf(noteId));

        if(note.getNoteContent() != null)
            dbNote.setNoteContent(note.getNoteContent());

        if(note.getNoteTitle() != null)
            dbNote.setNoteTitle(note.getNoteTitle());

        Note updated =noteService.updateNote(dbNote);

        return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{note_id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable(name = "note_id")String noteId){
        noteService.deleteNote(Long.valueOf(noteId));
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }
}
