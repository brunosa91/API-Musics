package com.reproduction.musics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MusicRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull
    @NotBlank
    private String titulo;
    private String artista;
    private String album;
    private String ano;
    private String genero;
    @NotNull
    private Long idList;
}
