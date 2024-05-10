package com.reproduction.musics.repository;

import com.reproduction.musics.model.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListRepository extends JpaRepository<ListEntity, Long> {
    Optional<ListEntity> findByNome(String nome);
}
