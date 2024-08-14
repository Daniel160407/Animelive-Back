package com.animelive.service.adminpanel;

import com.animelive.dto.AnimeDto;
import com.animelive.dto.EpisodeDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface AdminPanelService {
    void addAnime(AnimeDto animeDto, MultipartFile image);

    void addEpisodes(List<EpisodeDto> episodeDtos);
}
