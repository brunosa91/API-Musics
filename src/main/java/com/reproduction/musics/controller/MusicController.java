package com.reproduction.musics.controller;

import com.reproduction.musics.model.MusicEntity;
import com.reproduction.musics.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/{id}")
    public ResponseEntity<MusicEntity> getMusicById(@PathVariable Long id) {
        return ResponseEntity.ok(musicService.findMusicById(id));
    }

    @PostMapping
    public ResponseEntity<MusicEntity> postMusic(MusicEntity musicEntity) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(musicEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(musicService.insertMusic(musicEntity));
    }
}
