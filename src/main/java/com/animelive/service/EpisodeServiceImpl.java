package com.animelive.service;

import com.animelive.dto.EpisodeDto;
import com.animelive.model.Anime;
import com.animelive.repository.AnimeRepository;
import com.animelive.repository.EpisodeRepository;
import com.animelive.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    private final AnimeRepository animeRepository;
    private final EpisodeRepository episodeRepository;
    private final ModelConverter modelConverter;

    @Autowired
    public EpisodeServiceImpl(AnimeRepository animeRepository, EpisodeRepository episodeRepository, ModelConverter modelConverter) {
        this.animeRepository = animeRepository;
        this.episodeRepository = episodeRepository;
        this.modelConverter = modelConverter;
    }

    @Override
    public List<EpisodeDto> getEpisodesByAnimeName(String anime) {
        Anime anime1 = animeRepository.findByName(anime);
        if (anime1 != null) {
            List<EpisodeDto> episodeDtos = modelConverter.convertEpisodesToDtoList(episodeRepository.findAllByAnimeId(anime1.getId()));
            episodeDtos.forEach(episodeDto -> episodeDto.setAnime(anime));
            return episodeDtos;
        }
        return null;
    }
}
