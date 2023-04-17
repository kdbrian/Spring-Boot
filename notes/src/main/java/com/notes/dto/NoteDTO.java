package com.notes.dto;

import com.notes.model.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDTO {
    private String notetitle;

    private String noteContent;

    private Date dateCreated;

    private NotePriority priority;

    private enum NotePriority {HIGH, MEDIUM, LOW}
}
