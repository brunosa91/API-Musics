package com.reproduction.musics.controller;

import com.reproduction.musics.dto.MusicRequest;
import com.reproduction.musics.dto.MusicResponse;
import com.reproduction.musics.model.MusicEntity;
import com.reproduction.musics.service.MusicService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/music")
@Slf4j
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/{id}")
    public ResponseEntity<MusicResponse> getMusicByName(@PathVariable String title) {
        return ResponseEntity.ok(musicService.findMusicByTitle(title));
    }

    @PostMapping
    public ResponseEntity<MusicEntity> postMusic(@RequestBody @Valid MusicRequest musicRequest) {
        log.debug("PostMusic Saved {}",musicRequest);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(musicRequest.getId()).toUri();
        return ResponseEntity.created(uri).body(musicService.insertMusic(musicRequest));
    }
}
