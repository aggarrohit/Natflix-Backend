package com.novare.natflix.repositories;

import com.novare.natflix.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media,Long> {

    @Query("SELECT d.media FROM documentaries d " +
            "WHERE LOWER(d.media.title) LIKE %:searchTerm% OR " +
            "LOWER(d.media.summary) LIKE %:searchTerm% OR " +
            "LOWER(d.narrator) LIKE %:searchTerm%" )
    List<Media> searchDocumentariesWithText(String searchTerm);


    @Query("SELECT s.media FROM series s " +
            "WHERE LOWER(s.media.title) LIKE %:searchTerm% OR " +
            "LOWER(s.media.summary) LIKE %:searchTerm%")
    List<Media> searchSeriesWithText(String searchTerm);


    @Query("SELECT m.media FROM movies m " +
            "WHERE LOWER(m.media.title) LIKE %:searchTerm% OR " +
            "LOWER(m.media.summary) LIKE %:searchTerm% OR " +
            "LOWER(m.director) LIKE %:searchTerm%" )
    List<Media> searchMoviesWithText(String searchTerm);



    @Query("SELECT e.series.media FROM episodes e " +
            "WHERE LOWER(e.title) LIKE %:searchTerm% OR " +
            "LOWER(e.summary) LIKE %:searchTerm%")
    List<Media> searchSeriesEpisodesWithText(String searchTerm);

}
