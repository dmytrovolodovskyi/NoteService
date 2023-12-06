package com.example.service.notes.dto.create;

import lombok.Data;

@Data
public class CreateNoteRequest {
    private String title;
    private String content;
}