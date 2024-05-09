package com.reproduction.musics.service.impl;

import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.repository.ListRepository;
import com.reproduction.musics.service.ListService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListServiceImpl implements ListService {

    @Autowired
    ListRepository listRepository;

    @Override
    public ListEntity insertList(ListEntity listEntity) {
        return listRepository.save(listEntity);
    }

    @Override
    public List<ListEntity> findAllLists() {

        return listRepository.findAll();
    }

    @Override
    public Optional<ListEntity> findByNameList(String name) {

        return listRepository.findByName(name);
    }

    @Override
    public void deleteListByName(String name) {
        Optional<ListEntity> list = listRepository.findByName(name);
        listRepository.delete(list.get());
    }
}
