package com.animelive.service;

import com.animelive.dto.EpisodeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EpisodeService {
    List<EpisodeDto> getEpisodesByAnimeName(String anime);
}
