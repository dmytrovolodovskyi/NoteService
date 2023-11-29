package com.example.NoteService.controllers;

import com.example.NoteService.entities.Note;
import com.example.NoteService.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("ALL")
@RequiredArgsConstructor
@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    @ResponseBody
    public ModelAndView listNote() {
        ModelAndView result = new ModelAndView("note_list");
        result.addObject("noteList", noteService.getNotesList());
        return result;
    }

    @GetMapping("/add")
    public ModelAndView noteAddView() {
        return new ModelAndView("note_add");
    }

    @PostMapping("/add")
    public String createNote(
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);

        noteService.addNote(note);

        return "redirect:/note/list";
    }


    @GetMapping("/edit")
    public ModelAndView noteEditView() {
        return new ModelAndView("note_edit");
    }

    @PostMapping("/edit")
    public String updateNote(
            @RequestParam("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        if (noteService.getNotesList().contains(id)) {
            Note note = noteService.getById(id);
            note.setTitle(title);
            note.setContent(content);

            noteService.updateNote(note);
        }
        return "redirect:/note/list";
    }

    @GetMapping("/delete")
    public ModelAndView noteDeleteView() {
        return new ModelAndView("note_delete");
    }

    @PostMapping("/delete")
    public String deleteNote(
            @RequestParam("id") Long id
    ) {
        if (noteService.getNotesList().contains(id)) {
            noteService.deleteById(id);
        }

        return "redirect:/note/list";
    }

}
