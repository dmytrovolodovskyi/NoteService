package com.example.NoteService.service;

import com.example.NoteService.entities.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    public Note getById(Long id){
        Optional<Note> optionalNote = repository.findById(String.valueOf(id));
        return optionalNote.orElse(null);
    }

    public List<Note> getNotesList() {
        return repository.findAll();
    }

    public void addNote(Note note) {
        repository.save(note);
    }

    public void updateNote(Note note){
        repository.save(note);
    }

    public void deleteById(Long id) {
        repository.deleteById(String.valueOf(id));
    }
}
