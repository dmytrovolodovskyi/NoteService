package com.example.service.notes.dto.update;

import lombok.Data;

@Data
public class UpdateNoteRequest {
    private Long id;
    private String title;
    private String content;
}