package com.notes.service;

import com.notes.model.Note;
import com.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note insertNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public Note getNoteById(Long noteid){
        return noteRepository.findById(noteid).orElseThrow(RuntimeException::new);
    }

    public Note getNoteByTitle(String title){
        return noteRepository.findNoteByNoteTitle(title);
    }

    public List<Note> getNoteTitleContains(String match){
        return noteRepository.findNoteByNoteTitleContains(match);
    }

    public List<Note> getDayNotes(LocalDate datecreated){
        return noteRepository.findNoteByDateCreated(datecreated);
    }

    public void deleteNote(Long id){
        Note note = noteRepository.findById(id).orElseThrow(RuntimeException::new);
        noteRepository.delete(note);
    }

    public Note updateNote(Note note){
        Note note1 = noteRepository.findById(note.getId()).orElseThrow(RuntimeException::new);

        return noteRepository.save(note);
    }

    public void deleteNoteByTitle(String title){
        noteRepository.deleteNoteByNoteTitle(title);
    }

}
