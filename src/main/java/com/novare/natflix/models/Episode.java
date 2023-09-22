package com.novare.natflix.models;

import javax.persistence.*;

@Entity(name = "episodes")
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    int seasonNumber;
    int episodeNumber;
    String title;

    @Column(length = 255)
    String summary;
    String thumbnailUrl;
    String videoCode;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH,targetEntity = Series.class)
    @JoinColumn(name = "series_id")
    Series series;

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Episode() {
    }

    public Episode(Long id, int seasonNumber, int episodeNumber, String title, String summary, String thumbnailUrl, String videoCode) {
        this.id = id;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
        this.title = title;
        this.summary = summary;
        this.thumbnailUrl = thumbnailUrl;
        this.videoCode = videoCode;
    }


    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
