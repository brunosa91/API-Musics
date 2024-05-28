package com.reproduction.musics.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reproduction.musics.dto.ListResponse;
import com.reproduction.musics.exceptions_handler.exceptions.ListNotFound;
import com.reproduction.musics.mapper.Mapper;
import com.reproduction.musics.service.ListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.reproduction.musics.constants.Constants.*;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ListController.class)
public class ListControllerTest {
    @MockBean
    ListService listService;
    @MockBean
    Mapper mapper;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;


    @Test
    void getAllLists() throws Exception {
        List<ListResponse> list = new ArrayList<>();
        list.add(LIST_RESPONSE);
        when(listService.findAllLists()).thenReturn(list);
        mockMvc.perform(get("/list").with(httpBasic("bruno", "123")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("[0].id").value(LIST_RESPONSE.getId()));
        verify(listService, times(1)).findAllLists();
    }
    @Test
    void getAllLists_ReturnEmptyList() throws Exception {

        when(listService.findAllLists()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void getListByName() throws Exception {
        when(listService.findByNameList("rock")).thenReturn(LIST_RESPONSE);
        mockMvc.perform(get("/list/rock"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value(LIST_RESPONSE.getNome()));
        verify(listService, times(1)).findByNameList("rock");
    }

    @Test
    void getListByName_NotFound() throws Exception {
        when(listService.findByNameList("rock")).thenThrow(ListNotFound.class);
        mockMvc.perform(get("/list/rock"))
                .andExpect(status().isNotFound());
        verify(listService, times(1)).findByNameList("rock");
    }
    @Test
    void deleteListByName() throws Exception {
        doNothing().when(listService).deleteListByName("rock");
        mockMvc.perform(delete("/list/rock"))
                .andExpect(status().isNoContent());
        verify(listService, times(1)).deleteListByName("rock");
    }


    @Test
    void deleteListByName_NotFound() throws Exception {
        doThrow(ListNotFound.class).when(listService).deleteListByName("rock");
        mockMvc.perform(delete("/list/rock"))
                .andExpect(status().isNotFound());
        verify(listService, times(1)).deleteListByName("rock");
    }

    @Test
    void postLists() throws Exception {
        when(listService.insertList(LIST_REQUEST)).thenReturn(LIST_ENTITY);
        mockMvc.perform(post("/list")
                        .content(objectMapper.writeValueAsString(LIST_REQUEST))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpectAll(status().isCreated());

        verify(listService, times(1)).insertList(LIST_REQUEST);
    }

}
