package com.reproduction.musics.mapper;

import com.reproduction.musics.dto.ListRequest;
import com.reproduction.musics.dto.ListResponse;
import com.reproduction.musics.dto.MusicRequest;
import com.reproduction.musics.dto.MusicResponse;
import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.model.MusicEntity;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    ListEntity dtoToEntityList(ListRequest listRequest);

    ListResponse entityToDtoList(ListEntity listEntity);

    MusicResponse entityToDtoMusic(MusicEntity musicEntity);

    @Mapping(target = "lista.id", source = "idList")
    MusicEntity dtoToEntityMusic(MusicRequest request);
}
