package com.reproduction.musics.service.impl;

import com.reproduction.musics.dto.MusicRequest;
import com.reproduction.musics.dto.MusicResponse;
import com.reproduction.musics.mapper.Mapper;
import com.reproduction.musics.model.MusicEntity;
import com.reproduction.musics.repository.MusicRepository;
import com.reproduction.musics.service.MusicService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class MusicServiceImpl implements MusicService {
    @Autowired
    MusicRepository musicRepository;

    @Autowired
    Mapper mapper;

    @Override
    public MusicResponse findMusicByTitle(String title) {
        Optional<MusicEntity> musicEntity = musicRepository.findByTitulo(title);
        MusicResponse musicResponse = mapper.entityToDtoMusic(musicEntity.get());
        return musicResponse;
    }
    @Override
    public MusicEntity insertMusic(MusicRequest musicRequest) {
        MusicEntity musicEntity = mapper.dtoToEntityMusic(musicRequest);
        return musicRepository.save(musicEntity);
    }
}
