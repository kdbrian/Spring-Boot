package com.notes.repository;

import com.notes.model.Note;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    public Note findNoteByNoteTitle(String title);

    public List<Note> findNoteByDateCreated(LocalDate datecreated);
    public List<Note> findNoteByTimeCreated(LocalTime timeCreated);

    public List<Note> findNoteByNoteTitleContains(String match);
    @Transactional//must be there for delete statements
    public void deleteNoteByNoteTitle(String title);

}
