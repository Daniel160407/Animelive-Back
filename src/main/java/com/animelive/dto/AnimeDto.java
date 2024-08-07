package com.animelive.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimeDto {
    private String name;
    private Integer seasons;
    private String episodes;
    private String genre;
    private String releaseTime;
    private String studio;
    private String ageRestriction;
    private String episodeDuration;
    private Double imdb;
    private String description;
}
