package com.reproduction.musics.service;

import com.reproduction.musics.dto.ListResponse;
import com.reproduction.musics.exceptions_handler.exceptions.ListNotFound;
import com.reproduction.musics.mapper.Mapper;
import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.repository.ListRepository;
import com.reproduction.musics.service.impl.ListServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.reproduction.musics.constants.Constants.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListServiceTest {
    @InjectMocks
    private ListServiceImpl listService;
    @Mock
    ListRepository listRepository;
    @Mock
    Mapper mapper;

    @Test
    void getAllLists() {
        List<ListEntity> listEntities = new ArrayList<>();
        listEntities.add(LIST_ENTITY);
        when(listRepository.findAll()).thenReturn(listEntities);
        when(mapper
                .entityToDtoList(LIST_ENTITY))
                .thenReturn(LIST_RESPONSE);
        List<ListResponse> result = listService.findAllLists();
       verify(listRepository, times(1)).findAll();
       verify(mapper, times(1))
                .entityToDtoList(LIST_ENTITY);
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0)).isEqualTo(LIST_RESPONSE);
    }

    @Test
    void getAllLists_EmptyList() {
        when(listRepository.findAll()).thenReturn(Collections.emptyList());
        List<ListResponse> result = listService.findAllLists();
        verify(listRepository, times(1)).findAll();
        Assertions.assertThat(result).isEmpty();
        Assertions.assertThat(result).hasSize(0);
    }

    @Test
    void getListByName() {
        when(listRepository.findByNome("rock")).thenReturn(Optional.of(LIST_ENTITY));
        when(mapper
                .entityToDtoList(LIST_ENTITY))
                .thenReturn(LIST_RESPONSE);
        ListResponse result = listService.findByNameList("rock");
        verify(listRepository, times(1))
                .findByNome("rock");
        verify(mapper, times(1))
                .entityToDtoList(LIST_ENTITY);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getNome()).isEqualTo(LIST_RESPONSE.getNome());
    }

    @Test
    void getListByName_NotFound() {
        when(listRepository.findByNome("rock")).thenReturn(Optional.empty());
        Assertions.assertThatExceptionOfType(ListNotFound.class)
                        .isThrownBy(()->listService.findByNameList("rock"));
        verify(listRepository,times(1)).findByNome("rock");

    }

    @Test
    public void postList(){
        when(listRepository.save(LIST_ENTITY)).thenReturn(LIST_ENTITY);
        when(mapper.dtoToEntityList(LIST_REQUEST)).thenReturn(LIST_ENTITY);

        ListEntity result = listService.insertList(LIST_REQUEST);
        Assertions.assertThat(result).isEqualTo(LIST_ENTITY);
        verify(listRepository,times(1)).save(LIST_ENTITY);
    }

    @Test
    public void deleteList(){
        when(listRepository.findByNome("rock")).thenReturn(Optional.of(LIST_ENTITY));
        doNothing().when(listRepository).delete(LIST_ENTITY);
        Assertions.assertThatNoException()
                .isThrownBy(()->listService.deleteListByName("rock"));
        verify(listRepository,times(1)).findByNome("rock");
        verify(listRepository,times(1)).delete(LIST_ENTITY);
    }

    @Test
    public void deleteList_NotFound(){
        when(listRepository.findByNome("rock")).thenReturn(Optional.empty());
        Assertions.assertThatExceptionOfType(ListNotFound.class)
                .isThrownBy(()->listService.deleteListByName("rock"));

        verify(listRepository,times(1)).findByNome("rock");
        verify(listRepository,never()).delete(any((ListEntity.class)));
    }





}
