package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.repository.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepo songRepo;

    @Override
    public List<Song> getAllSong() {
        return songRepo.findAll();
    }

    @Override
    public void addSong(Song song) {
        songRepo.save(song);
    }

    @Override
    public void updateSong(Song song) {
        songRepo.save(song);
    }

    @Override
    public Song findSongById(Integer id) {
        return songRepo.findById(id).get();
    }
}
