package com.animelive.service;

import com.animelive.dto.AnimeDto;
import com.animelive.model.Anime;
import com.animelive.repository.AnimeRepository;
import com.animelive.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {
    private final AnimeRepository animeRepository;
    private final ModelConverter modelConverter;

    @Autowired
    public AnimeServiceImpl(AnimeRepository animeRepository, ModelConverter modelConverter) {
        this.animeRepository = animeRepository;
        this.modelConverter = modelConverter;
    }

    @Override
    public List<AnimeDto> getAnimes(int page) {
        if (page < 0) {
            page = 0;
        }
        Pageable pageable = PageRequest.of(page, 30, Sort.by(Sort.Direction.DESC, "imdb"));
        List<Anime> animes = animeRepository.findAll(pageable).getContent();
        return modelConverter.convertAnimeListToDto(animes);
    }

    @Override
    public List<AnimeDto> getAnimesByGanre(String ganre) {
        return List.of();
    }

    @Override
    public AnimeDto getAnimeByName(String name) {
        return null;
    }
}
