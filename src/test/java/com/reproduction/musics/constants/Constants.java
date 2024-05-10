package com.reproduction.musics.constants;

import com.reproduction.musics.dto.ListRequest;
import com.reproduction.musics.dto.ListResponse;
import com.reproduction.musics.dto.MusicRequest;
import com.reproduction.musics.dto.MusicResponse;
import com.reproduction.musics.model.ListEntity;
import com.reproduction.musics.model.MusicEntity;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final List<MusicEntity> MUSIC_ENTITY_LIST = new ArrayList<>();
    public static final List<MusicRequest> MUSIC_REQUEST_LIST = new ArrayList<>();
    public static final List<MusicResponse> MUSIC_RESPONSE_LIST = new ArrayList<>();

    public static final ListEntity LIST_ENTITY = new ListEntity(1L,"rock","para treinar",MUSIC_ENTITY_LIST);
    public static final ListRequest LIST_REQUEST = new ListRequest(1L,"rock","para treinar",MUSIC_REQUEST_LIST);
    public static final ListResponse LIST_RESPONSE = new ListResponse(1L,"rock","para treinar",MUSIC_RESPONSE_LIST);
    public static final MusicEntity MUSIC_ENTITY = new MusicEntity(1L,"Numb","Link Park", "Meteora","2003","rock",LIST_ENTITY);

    public static final MusicResponse MUSIC_RESPONSE = new MusicResponse(1L,"Numb","Link Park", "Meteora","2003","rock");
    public static final MusicRequest MUSIC_REQUEST = new MusicRequest(1L,"Numb","Link Park", "Meteora","2003","rock",1L);

}
