package com.animelive.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
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
    private String imageUrl;
}
