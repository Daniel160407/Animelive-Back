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
@Table(name = "animes")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "seasons")
    private Integer seasons;
    @Column(name = "episodes")
    private Integer episodes;
    @Column(name = "ganre")
    private String ganre;
    @Column(name = "release_time")
    private String releaseTime;
    @Column(name = "studio")
    private String studio;
    @Column(name = "age_restriction")
    private String ageRestriction;
    @Column(name = "episode_duration")
    private String episodeDuration;
    @Column(name = "imdb")
    private Double imdb;
    @Column(name = "description")
    private String description;
}
