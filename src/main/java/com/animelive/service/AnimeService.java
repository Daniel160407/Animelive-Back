package com.animelive.service;

import com.animelive.dto.AnimeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimeService {
    List<AnimeDto> getAnimes(int page);

    List<AnimeDto> getAnimesByGenre(String genre);

    AnimeDto getAnimeByName(String name);
    List<AnimeDto>getAnimesStartingWith(String prefix);
}
