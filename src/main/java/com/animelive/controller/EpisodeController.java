package com.animelive.controller;

import com.animelive.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/episode")
@CrossOrigin(origins = "*")
public class EpisodeController {
    private final EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public ResponseEntity<?> getEpisodes(@RequestParam String anime) {
        return ResponseEntity.ok().body(episodeService.getEpisodesByAnimeName(anime));
    }
}
