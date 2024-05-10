package com.reproduction.musics.repository;

import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.model.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<MusicEntity, Long> {
    Optional<MusicEntity> findByTitulo(String titulo);

}
