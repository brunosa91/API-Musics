package com.reproduction.musics.dto;

import lombok.Data;

@Data
public class MusicRequest {


    private String title;

    private String artist;
    private String album;
      private String year;

    private String genre;
    private Long idList;
}
