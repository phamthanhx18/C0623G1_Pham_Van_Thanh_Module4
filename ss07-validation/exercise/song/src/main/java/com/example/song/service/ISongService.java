package com.example.song.service;

import com.example.song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAllSong();
    void addSong(Song song);
    void updateSong(Song song);
    Song findSongById(Integer id);
}
