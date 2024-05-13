package com.reproduction.musics.service.impl;

import com.reproduction.musics.dto.MusicRequest;
import com.reproduction.musics.dto.MusicResponse;
import com.reproduction.musics.exceptions_handler.exceptions.ListNotFound;
import com.reproduction.musics.exceptions_handler.exceptions.MusicNotFound;
import com.reproduction.musics.mapper.Mapper;
import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.model.MusicEntity;
import com.reproduction.musics.repository.ListRepository;
import com.reproduction.musics.repository.MusicRepository;
import com.reproduction.musics.service.MusicService;
import jakarta.persistence.EntityNotFoundException;
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
    ListRepository listRepository;

    @Autowired
    Mapper mapper;

    @Override
    public MusicResponse findMusicByTitle(String title) {
        Optional<MusicEntity> musicEntity = musicRepository.findByTitulo(title);
        if (musicEntity.isEmpty()){
            throw new MusicNotFound();
        }
        MusicResponse musicResponse = mapper.entityToDtoMusic(musicEntity.get());
        return musicResponse;
    }
    @Override
    public MusicEntity insertMusic(MusicRequest musicRequest) {

        MusicEntity musicEntity = mapper.dtoToEntityMusic(musicRequest);
        Optional<ListEntity> optionalListEntity = listRepository.findById(musicEntity.getLista().getId());
        if (optionalListEntity.isEmpty()) {
            throw new ListNotFound();
        }
        return musicRepository.save(musicEntity);
    }
}
