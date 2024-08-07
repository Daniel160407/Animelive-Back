package com.animelive.controller;

import com.animelive.dto.AnimeDto;
import com.animelive.dto.EpisodeDto;
import com.animelive.service.adminpanel.AdminPanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> addAnime(@RequestBody AnimeDto animeDto) {
        adminPanelService.addAnime(animeDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/episode")
    public ResponseEntity<?> addEpisodes(@RequestBody List<EpisodeDto> episodeDtos) {
        adminPanelService.addEpisodes(episodeDtos);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
