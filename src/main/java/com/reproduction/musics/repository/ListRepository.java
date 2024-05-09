package com.reproduction.musics.repository;

import com.reproduction.musics.model.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListEntity, Long> {
}
