package com.animelive.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {
    private String anime;
    private Integer season;
    private Integer episode;
    private String url;

    public EpisodeDto(Integer season, Integer episode, String url) {
        this.season = season;
        this.episode = episode;
        this.url = url;
    }
}
