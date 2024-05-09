package com.reproduction.musics.service.impl;

import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.repository.ListRepository;
import com.reproduction.musics.service.ListService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListServiceImpl implements ListService {

    @Autowired
    ListRepository listRepository;

    @Override
    public ListEntity insertList(ListEntity listEntity) {
        return null;
    }

    @Override
    public List<ListEntity> findAllLists() {
        return null;
    }

    @Override
    public ListEntity findByNameList(String name) {
        return null;
    }

    @Override
    public void deleteListByName(String name) {

    }
}
