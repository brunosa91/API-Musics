package com.reproduction.musics.Repository;

import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.repository.ListRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static com.reproduction.musics.constants.Constants.LIST_ENTITY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ListRepositoryTest {
    
    @Autowired
    ListRepository listRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @AfterEach
    void afterEach() {
        LIST_ENTITY.setId(null);
    }

    @Test
    void save_data_listEntity() {
        ListEntity listEntity = listRepository.save(LIST_ENTITY);
        ListEntity sut = testEntityManager.find(ListEntity.class, listEntity.getId());
        assertThatNoException().isThrownBy(
                () -> listRepository.save(LIST_ENTITY));
        assertThat(sut).isNotNull();
        assertThat(sut.getNome()).isEqualTo(listEntity.getNome());
        assertThat(sut.getDescricao()).isEqualTo(listEntity.getDescricao());
    }

    @Test
    void findListByNome() {
        Optional<ListEntity> persistedEntity = Optional.ofNullable(testEntityManager.merge(LIST_ENTITY));
        Optional<ListEntity> result = listRepository.findByNome(LIST_ENTITY.getNome());
        assertThat(result).isPresent();
        ListEntity foundEntity = result.get();

        assertThat(foundEntity.getNome()).isEqualTo(persistedEntity.get().getNome());
    }

    @Test
    void findListByNome_returnsEmptyOptional() {

        Optional<ListEntity> optionalListEntity = listRepository.findByNome("rock");

        assertThat(optionalListEntity).isEmpty();

    }
}
