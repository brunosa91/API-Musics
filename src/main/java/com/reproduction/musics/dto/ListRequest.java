package com.reproduction.musics.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ListRequest {

    private String name;

    private String decription;

    List<MusicRequest> musicsList = new ArrayList<>();
}
