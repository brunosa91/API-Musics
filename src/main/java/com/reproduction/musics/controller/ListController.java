package com.reproduction.musics.controller;

import com.reproduction.musics.dto.ListRequest;
import com.reproduction.musics.dto.ListResponse;
import com.reproduction.musics.mapper.Mapper;
import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.service.ListService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/list")
@Slf4j

public class ListController {
    @Autowired
    private ListService listService;
    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<List<ListResponse>> getAllLists() {
        return ResponseEntity.ok(listService.findAllLists());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ListResponse> getListByName(@PathVariable String name) {
        log.debug("getListByName received {}",name);

        return ResponseEntity.ok(listService.findByNameList(name));
    }
    @PostMapping
    public ResponseEntity<ListResponse> postList(@RequestBody @Valid ListRequest listRequest) {
        log.debug("PostList Saved {}",listRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(listRequest.getId()).toUri();
        ListEntity listEntity = listService.insertList(listRequest);
        ListResponse listResponse = mapper.entityToDtoList(listEntity);
        return ResponseEntity.created(uri).body(listResponse);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteList(@PathVariable String name) {
        listService.deleteListByName(name);
        return ResponseEntity.noContent().build();
    }


}
