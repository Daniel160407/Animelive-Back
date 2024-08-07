package com.animelive.controller;

import com.animelive.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anime")
@CrossOrigin(origins = "*")
public class AnimeController {
    private final AnimeService animeService;

    @Autowired
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public ResponseEntity<?> getAnimes(@RequestParam Integer page) {
        return ResponseEntity.ok().body(animeService.getAnimes(page));
    }
}
