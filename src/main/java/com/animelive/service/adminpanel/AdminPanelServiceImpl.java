package com.animelive.service.adminpanel;

import com.animelive.dto.AnimeDto;
import com.animelive.dto.EpisodeDto;
import com.animelive.model.Episode;
import com.animelive.repository.AnimeRepository;
import com.animelive.repository.EpisodeRepository;
import com.animelive.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {
    private final AnimeRepository animeRepository;
    private final EpisodeRepository episodeRepository;
    private final ModelConverter modelConverter;
    private final String UPLOAD_DIR;


    @Autowired
    public AdminPanelServiceImpl(AnimeRepository animeRepository, EpisodeRepository episodeRepository, ModelConverter modelConverter) {
        this.animeRepository = animeRepository;
        this.episodeRepository = episodeRepository;
        this.modelConverter = modelConverter;
        this.UPLOAD_DIR = "src/main/resources/images/";
    }

    @Override
    public void addAnime(AnimeDto animeDto, MultipartFile image) {
        animeRepository.save(modelConverter.convert(animeDto));

        if (image.isEmpty()) {
            throw new RuntimeException();
        }

        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String filePath = UPLOAD_DIR + System.currentTimeMillis() + "_" + image.getOriginalFilename();
            image.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addEpisodes(List<EpisodeDto> episodeDtos) {
        int animeId = animeRepository.findByName(episodeDtos.get(0).getAnime()).getId();
        List<Episode> episodes = modelConverter.convertEpisodeDtosToEpisodesList(episodeDtos);
        episodes.forEach(episode -> {
            episode.setAnimeId(animeId);
            episodeRepository.save(episode);
        });
    }
}
