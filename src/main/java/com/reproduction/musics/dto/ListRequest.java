package com.reproduction.musics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    private String descricao;

    List<MusicRequest> musicas = new ArrayList<>();
}
