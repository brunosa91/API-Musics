package com.reproduction.musics.service;

import com.reproduction.musics.dto.MusicRequest;
import com.reproduction.musics.dto.MusicResponse;
import com.reproduction.musics.model.MusicEntity;

import java.util.List;

public interface MusicService {
   MusicResponse findMusicByTitle(String title);

   MusicEntity insertMusic(MusicRequest musicRequest);
}
