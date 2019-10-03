package com.example.Musicapp.Controller;

import com.example.Musicapp.model.Song;
import com.example.Musicapp.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongService songService;

    @PostMapping
    public Song createSong(@RequestBody Song song){
        return songService.createSong(song);
    }
    @GetMapping("/list")
    public Iterable<Song>listSongs(){
        return songService.listSongs();
    }

    @DeleteMapping("/{songId}")
    public HttpStatus deleteSongById(@PathVariable Integer songId) {
        return songService.deleteById(songId);
    }

}





