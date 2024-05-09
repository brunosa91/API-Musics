package com.reproduction.musics.repository;

import com.reproduction.musics.model.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicEntity, Long> {
}
