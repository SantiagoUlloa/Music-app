package com.example.Musicapp.repository;

import com.example.Musicapp.models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository <Song, Integer> {

}
