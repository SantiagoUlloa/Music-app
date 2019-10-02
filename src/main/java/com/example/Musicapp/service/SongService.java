package com.example.Musicapp.service;

import com.example.Musicapp.model.Song;
import org.springframework.http.HttpStatus;

public interface SongService {
    public Song createSong(Song song);

    public Iterable<Song> listSongs();

    public HttpStatus deleteById(Long songId);

}
