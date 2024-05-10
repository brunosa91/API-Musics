package com.reproduction.musics.service;

import com.reproduction.musics.dto.ListRequest;
import com.reproduction.musics.dto.ListResponse;
import com.reproduction.musics.model.ListEntity;

import java.util.List;
import java.util.Optional;

public interface ListService {
    ListEntity insertList(ListRequest listRequest);
    List<ListResponse> findAllLists();
    ListResponse findByNameList(String name);
    void deleteListByName(String name);


}
