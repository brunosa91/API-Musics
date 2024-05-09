package com.reproduction.musics.service.impl;

import com.reproduction.musics.model.MusicEntity;
import com.reproduction.musics.repository.MusicRepository;
import com.reproduction.musics.service.MusicService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MusicServiceImpl implements MusicService {
    @Autowired
    MusicRepository musicRepository;

    @Override
    public MusicEntity findMusicById(Long id) {
        return null;
    }

    @Override
    public MusicEntity insertMusic(MusicEntity musicEntity) {
        return null;
    }
}
