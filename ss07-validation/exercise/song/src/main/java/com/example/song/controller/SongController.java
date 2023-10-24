package com.example.song.controller;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public ModelAndView showHome() {
        return new ModelAndView("index", "songs", songService.getAllSong());
    }

    @GetMapping("/song/add")
    public ModelAndView showFormAdd() {
        return new ModelAndView("add", "songDTO", new SongDTO());
    }

    @PostMapping("/song/add")
    public ModelAndView saveSong(@Valid @ModelAttribute SongDTO songDTO,
                                 BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("add", "songDTO", songDTO);
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            songService.addSong(song);
            return new ModelAndView("index", "songs", songService.getAllSong());
        }
    }

    @GetMapping("/song/{id}/edit")
    public ModelAndView showFormAdd(@PathVariable Integer id) {
        Song song = songService.findSongById(id);
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song, songDTO);
        return new ModelAndView("edit", "songDTO", songDTO);
    }

    @PostMapping("/song/{id}/edit")
    public ModelAndView updateSong(@Valid @ModelAttribute SongDTO songDTO,
                                   BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("edit", "songDTO", songDTO);
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            songService.updateSong(song);
            return new ModelAndView("index", "songs", songService.getAllSong());
        }
    }
}
