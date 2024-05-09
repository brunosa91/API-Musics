package com.reproduction.musics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "list_table")
@Data
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @JsonProperty("nome")
    private String name;
    @Column
    @JsonProperty("descricao")
    private String decription;
    @OneToMany(mappedBy = "listEntity", cascade = CascadeType.ALL)
    @JsonProperty("musicas")
    private List<MusicEntity> musicEntityList = new ArrayList<>();

}