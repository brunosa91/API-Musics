package com.reproduction.musics.service;

import com.reproduction.musics.model.ListEntity;

import java.util.List;

public interface ListService {
    ListEntity insertList(ListEntity listEntity);
    List<ListEntity> findAllLists();
    ListEntity findByNameList(String name);
    void deleteListByName(String name);


}
