package com.notes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {

    @Id
    @SequenceGenerator(name = "note_seq", sequenceName ="note_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
    @Column(name = "note_id")
    private Long id;

    @Column(name = "note_title")
    private String noteTitle;

    @Column(name = "note_content")
    private String noteContent;

    @Column(name = "datecreated")
    private LocalDate dateCreated;

    @Column(name = "timecreated")
    private LocalTime timeCreated;

    @Column(name = "note_priority")
    @Enumerated(EnumType.STRING)
    private NotePriority priority;

    public enum NotePriority {HIGH, MEDIUM, LOW}

}
