package com.animelive.service;

import com.animelive.dto.AnimeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimeService {
    List<AnimeDto> getAnimes(int page);

    List<AnimeDto> getAnimesByGanre(String ganre);

    AnimeDto getAnimeByName(String name);
}
