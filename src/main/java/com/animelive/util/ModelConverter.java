package com.animelive.util;

import com.animelive.dto.AnimeDto;
import com.animelive.dto.EpisodeDto;
import com.animelive.model.Anime;
import com.animelive.model.Episode;
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
                .seasons(anime.getSeasons())
                .episodes(anime.getEpisodes())
                .ganre(anime.getGanre())
                .releaseTime(anime.getReleaseTime())
                .studio(anime.getStudio())
                .ageRestriction(anime.getAgeRestriction())
                .episodeDuration(anime.getEpisodeDuration())
                .imdb(anime.getImdb())
                .description(anime.getDescription())
                .build();
    }

    public Anime convert(AnimeDto animeDto) {
        return Anime.builder()
                .name(animeDto.getName())
                .seasons(animeDto.getSeasons())
                .episodes(animeDto.getEpisodes())
                .ganre(animeDto.getGanre())
                .releaseTime(animeDto.getReleaseTime())
                .studio(animeDto.getStudio())
                .ageRestriction(animeDto.getAgeRestriction())
                .episodeDuration(animeDto.getEpisodeDuration())
                .imdb(animeDto.getImdb())
                .description(animeDto.getDescription())
                .build();
    }

    public List<EpisodeDto> convertEpisodesToDtoList(List<Episode> episodes) {
        List<EpisodeDto> episodeDtos = new ArrayList<>();
        episodes.forEach(episode -> episodeDtos.add(new EpisodeDto(episode.getSeason(), episode.getEpisode(), episode.getUrl())));
        return episodeDtos;
    }

    public List<Episode> convertEpisodeDtosToEpisodesList(List<EpisodeDto> episodeDtos) {
        List<Episode> episodes = new ArrayList<>();
        episodeDtos.forEach(episodeDto -> episodes.add(new Episode(episodeDto.getSeason(), episodeDto.getEpisode(), episodeDto.getUrl())));
        return episodes;
    }
}
