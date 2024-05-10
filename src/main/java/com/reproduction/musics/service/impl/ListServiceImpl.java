package com.reproduction.musics.service.impl;

import com.reproduction.musics.dto.ListRequest;
import com.reproduction.musics.dto.ListResponse;
import com.reproduction.musics.mapper.Mapper;
import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.repository.ListRepository;
import com.reproduction.musics.service.ListService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ListServiceImpl implements ListService {

    @Autowired
    ListRepository listRepository;
    @Autowired
    Mapper mapper;

    @Override
    public ListEntity insertList(ListRequest listRequest) {
        log.info("InserListService received {}",listRequest);
        ListEntity listEntity = mapper.dtoToEntityList(listRequest);
        log.info("InserListService mapped {}",listEntity);

        return listRepository.save(listEntity);
    }

    @Override
    public List<ListResponse> findAllLists() {
       List<ListEntity> listEntities =listRepository.findAll();
       List<ListResponse> listResponses = listEntities.stream()
               .map(listEntity -> mapper.entityToDtoList(listEntity)).collect(Collectors.toList());

        return listResponses;
    }

    @Override
    public ListResponse findByNameList(String name) {
       Optional <ListEntity> listEntity = listRepository.findByNome(name);
       ListResponse listResponse = mapper.entityToDtoList(listEntity.get());

        return listResponse ;
    }

    @Override
    public void deleteListByName(String name) {
        Optional <ListEntity> list = listRepository.findByNome(name);
        listRepository.delete(list.get());
    }
}
