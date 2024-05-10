package com.reproduction.musics.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reproduction.musics.exceptions_handler.exceptions.MusicNotFound;
import com.reproduction.musics.mapper.Mapper;
import com.reproduction.musics.service.MusicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.reproduction.musics.constants.Constants.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MusicController.class)
public class MusicControllerTest {
    @MockBean
    MusicService musicService;
    @MockBean
    Mapper mapper;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;


    @Test
    void getMusicByTitle() throws Exception {
        when(musicService.findMusicByTitle("numb")).thenReturn(MUSIC_RESPONSE);
        mockMvc.perform(get("/music/numb"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value(MUSIC_RESPONSE.getTitulo()));
        verify(musicService, times(1)).findMusicByTitle("numb");
    }

    @Test
    void getListByName_NotFound() throws Exception {
        when(musicService.findMusicByTitle("numb")).thenThrow(MusicNotFound.class);
        mockMvc.perform(get("/music/numb"))
                .andExpect(status().isNotFound());
        verify(musicService, times(1)).findMusicByTitle("numb");
    }

    @Test
    void postMusic() throws Exception {
        when(musicService.insertMusic(MUSIC_REQUEST)).thenReturn(MUSIC_ENTITY);
        mockMvc.perform(post("/music")
                        .content(objectMapper.writeValueAsString(MUSIC_REQUEST))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isCreated());

        verify(musicService, times(1)).insertMusic(MUSIC_REQUEST);
    }

}
