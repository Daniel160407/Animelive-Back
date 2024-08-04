package com.animelive.util;

import com.animelive.dto.AnimeDto;
import com.animelive.model.Anime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelConverter {
    public List<AnimeDto> convertAnimeListToDto(List<Anime> animes) {
        List<AnimeDto> animeDtos = new ArrayList<>();
        animes.forEach(anime -> animeDtos.add(convert(anime)));
        return animeDtos;
    }

    public AnimeDto convert(Anime anime) {
        return AnimeDto.builder()
                .name(anime.getName())
                .episodes(anime.getEpisodes())
                .ganre(anime.getGanre())
                .releaseTime(anime.getReleaseTime())
                .studio(anime.getStudio())
                .ageRestriction(anime.getAgeRestriction())
                .apisodeDuration(anime.getEpisodeDuration())
                .imdb(anime.getImdb())
                .description(anime.getDescription())
                .url(anime.getUrl())
                .build();
    }
}
