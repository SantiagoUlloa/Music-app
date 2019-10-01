package com.example.Musicapp.service;

import com.example.Musicapp.model.Song;

public interface SongService {
    public Song createSong(Song song);

    public Iterable<Song> listSongs();

//    public HttpStatus deleteById(Long songId);

}
