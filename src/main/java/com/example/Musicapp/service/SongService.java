package com.example.Musicapp.service;

import com.example.Musicapp.models.Song;
import org.springframework.stereotype.Service;

public interface SongService {
    public Song createSong(Song song);

    public Iterable<Song> listSongs();

}
