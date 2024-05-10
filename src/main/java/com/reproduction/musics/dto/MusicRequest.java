package com.reproduction.musics.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MusicRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String titulo;
    private String artista;
    private String album;
    private String ano;
    private String genero;
    private Long idList;
}
