package com.animelive.service.adminpanel;

import com.animelive.dto.AnimeDto;
import com.animelive.dto.EpisodeDto;
import com.animelive.model.Episode;
import com.animelive.repository.AnimeRepository;
import com.animelive.repository.EpisodeRepository;
import com.animelive.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {
    private final AnimeRepository animeRepository;
    private final EpisodeRepository episodeRepository;
    private final ModelConverter modelConverter;

    @Autowired
    public AdminPanelServiceImpl(AnimeRepository animeRepository, EpisodeRepository episodeRepository, ModelConverter modelConverter) {
        this.animeRepository = animeRepository;
        this.episodeRepository = episodeRepository;
        this.modelConverter = modelConverter;
    }

    @Override
    public void addAnime(AnimeDto animeDto) {
        animeRepository.save(modelConverter.convert(animeDto));
    }

    @Override
    public void addEpisodes(List<EpisodeDto> episodeDtos) {
        int animeId = animeRepository.findByName(episodeDtos.get(0).getAnime()).getId();
        List<Episode> episodes = modelConverter.convertEpisodeDtosToEpisodesList(episodeDtos);
        episodes.forEach(episode -> {
            episode.setAnimeId(animeId);
            episodeRepository.save(episode);
        });
    }
}
