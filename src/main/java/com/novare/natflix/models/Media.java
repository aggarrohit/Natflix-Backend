package com.novare.natflix.models;

import javax.persistence.*;

@Entity(name = "medias")
@Table(name = "medias")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private int mediaTypeId;
    private int genreId;

    @Column(length = 5000)
    private String summary;
    private String bannerUrl;
    private String thumbnailUrl;


    public Media() {
    }

    public Media(Long id, String title, int mediaTypeId, int genreId, String summary, String bannerUrl, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.mediaTypeId = mediaTypeId;
        this.genreId = genreId;
        this.summary = summary;
        this.bannerUrl = bannerUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(int mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }


}
