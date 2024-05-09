package com.reproduction.musics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "music_table")
@Data
public class MusicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @JsonProperty("titulo")
    private String title;
    @Column
    @JsonProperty("artista")
    private String artist;
    @Column
    private String album;
    @Column
    @JsonProperty("ano")
    private String year;
    @Column
    @JsonProperty("genero")
    private String genre;
    @ManyToOne
    private ListEntity listEntity;


}
