package com.reproduction.musics.service;

import com.reproduction.musics.model.MusicEntity;

import java.util.List;

public interface MusicService {
   MusicEntity findMusicById(Long id);

   MusicEntity insertMusic(MusicEntity musicEntity);
}
