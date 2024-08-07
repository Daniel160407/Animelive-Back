package com.animelive.repository;

import com.animelive.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer> {
    Anime findByName(String name);

    List<Anime> findAllByGenre(String genre);

    List<Anime> findAllByGenreStartingWith(String prefix);
}
