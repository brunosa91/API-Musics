package com.reproduction.musics.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ListResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String descricao;

    private List<MusicResponse> musicas = new ArrayList<>();
}
