package com.novare.natflix.repositories;

import com.novare.natflix.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Long> {
    List<Episode> findBySeriesId(Long id);

    List<Episode> findBySeries_Media_Id(Long id);
}
