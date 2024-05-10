package com.reproduction.musics.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "music_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MusicEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String artista;
    @Column
    private String album;
    @Column
    private String ano;
    @Column
    private String genero;
    @ManyToOne
    private ListEntity lista;


}
