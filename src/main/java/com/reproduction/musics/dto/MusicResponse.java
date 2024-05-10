package com.reproduction.musics.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MusicResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private Long id;
    private String titulo;
    private String artista;
    private String album;
    private String ano;
    private String genero;


}
