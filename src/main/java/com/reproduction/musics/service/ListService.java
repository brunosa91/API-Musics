package com.reproduction.musics.service;

import com.reproduction.musics.model.ListEntity;

import java.util.List;
import java.util.Optional;

public interface ListService {
    ListEntity insertList(ListEntity listEntity);
    List<ListEntity> findAllLists();
    Optional<ListEntity> findByNameList(String name);
    void deleteListByName(String name);


}
