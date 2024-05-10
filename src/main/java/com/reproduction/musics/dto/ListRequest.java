package com.reproduction.musics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ListRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    private String descricao;

    List<MusicRequest> musicas = new ArrayList<>();
}
