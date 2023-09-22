package com.novare.natflix.repositories;

import com.novare.natflix.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Long> {
    Series findByMediaId(Long id);
}
