package com.reproduction.musics.controller;

import com.reproduction.musics.dto.ListRequest;
import com.reproduction.musics.dto.ListResponse;
import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.service.ListService;
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
    public ResponseEntity<ListEntity> postList(@RequestBody ListRequest listRequest) {
        log.debug("PostList Saved {}",listRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(listRequest.getId()).toUri();
        return ResponseEntity.created(uri).body(listService.insertList(listRequest));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteList(@PathVariable String name) {
        listService.deleteListByName(name);
        return ResponseEntity.noContent().build();
    }


}
