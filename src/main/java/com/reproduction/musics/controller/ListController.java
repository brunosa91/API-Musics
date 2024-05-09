package com.reproduction.musics.controller;

import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/list")
public class ListController {
    @Autowired
    private ListService listService;

    @GetMapping
    public ResponseEntity<List<ListEntity>> getAllLists() {
        return ResponseEntity.ok(listService.findAllLists());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<ListEntity>> getListByName(@PathVariable String name) {
        return ResponseEntity.ok(listService.findByNameList(name));
    }
    @PostMapping
    public ResponseEntity<ListEntity> postList(ListEntity listEntity) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(listEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(listService.insertList(listEntity));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteList(@PathVariable String name) {
        listService.deleteListByName(name);
        return ResponseEntity.noContent().build();
    }


}
