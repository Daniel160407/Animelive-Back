package com.animelive.service.adminpanel;

import com.animelive.dto.AnimeDto;
import com.animelive.dto.EpisodeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminPanelService {
    void addAnime(AnimeDto animeDto);
    void addEpisodes(List<EpisodeDto>episodeDtos);
}
