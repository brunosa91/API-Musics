package com.reproduction.musics.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ListResponse {
    private String id;
    private String name;

    private String decription;

    List<MusicRequest> musicsList = new ArrayList<>();
}
