package com.reproduction.musics.service;

import com.reproduction.musics.dto.MusicResponse;
import com.reproduction.musics.exceptions_handler.exceptions.MusicNotFound;
import com.reproduction.musics.mapper.Mapper;
import com.reproduction.musics.model.MusicEntity;
import com.reproduction.musics.repository.MusicRepository;
import com.reproduction.musics.service.impl.MusicServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.reproduction.musics.constants.Constants.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MusicServiceTest {
    @InjectMocks
    private MusicServiceImpl musicService;
    @Mock
    MusicRepository musicRepository;
    @Mock
    Mapper mapper;

    @Test
    void getMusicByTitle() {
        when(musicRepository.findByTitulo("numb")).thenReturn(Optional.of(MUSIC_ENTITY));
        when(mapper
                .entityToDtoMusic(MUSIC_ENTITY))
                .thenReturn(MUSIC_RESPONSE);
        MusicResponse result = musicService.findMusicByTitle("numb");
        verify(musicRepository, times(1))
                .findByTitulo("numb");
        verify(mapper, times(1))
                .entityToDtoMusic(MUSIC_ENTITY);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getTitulo()).isEqualTo(MUSIC_RESPONSE.getTitulo());
    }

    @Test
    void getMusicByTitle_NotFound() {
        when(musicRepository.findByTitulo("numb")).thenReturn(Optional.empty());
        Assertions.assertThatExceptionOfType(MusicNotFound.class)
                        .isThrownBy(()->musicService.findMusicByTitle("numb"));
        verify(musicRepository,times(1)).findByTitulo("numb");

    }

    @Test
    public void postMusic(){
        when(musicRepository.save(MUSIC_ENTITY)).thenReturn(MUSIC_ENTITY);
        when(mapper.dtoToEntityMusic(MUSIC_REQUEST)).thenReturn(MUSIC_ENTITY);

        MusicEntity result = musicService.insertMusic(MUSIC_REQUEST);
        Assertions.assertThat(result).isEqualTo(MUSIC_ENTITY);
        verify(musicRepository,times(1)).save(MUSIC_ENTITY);
    }

}
