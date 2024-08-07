package com.animelive.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "anime_id")
    private Integer animeId;
    @Column(name = "season")
    private Integer season;
    @Column(name = "episode")
    private Integer episode;
    @Column(name = "url")
    private String url;

    public Episode(Integer season, Integer episode, String url) {
        this.season = season;
        this.episode = episode;
        this.url = url;
    }
}
