package com.animelive.controller;

import com.animelive.dto.AnimeDto;
import com.animelive.dto.EpisodeDto;
import com.animelive.service.adminpanel.AdminPanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/adminpanel")
@CrossOrigin(origins = "*")
public class AdminPanelController {
    private final AdminPanelService adminPanelService;

    @Autowired
    public AdminPanelController(AdminPanelService adminPanelService) {
        this.adminPanelService = adminPanelService;
    }

    @PostMapping
    public ResponseEntity<?> addAnime(@RequestPart String name,
                                      @RequestPart Integer seasons,
                                      @RequestPart String episodes,
                                      @RequestPart String genre,
                                      @RequestPart String releaseTime,
                                      @RequestPart String studio,
                                      @RequestPart String ageRestriction,
                                      @RequestPart String episodeDuration,
                                      @RequestPart Double imdb,
                                      @RequestPart String description,
                                      @RequestPart String imageUrl,
                                      @RequestPart MultipartFile image) {
        try {
            adminPanelService.addAnime(new AnimeDto(name, seasons, episodes, genre, releaseTime, studio, ageRestriction, episodeDuration, imdb, description, imageUrl), image);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/episode")
    public ResponseEntity<?> addEpisodes(@RequestBody List<EpisodeDto> episodeDtos) {
        adminPanelService.addEpisodes(episodeDtos);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
