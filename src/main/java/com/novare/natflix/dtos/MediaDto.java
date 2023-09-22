package com.novare.natflix.dtos;

import org.springframework.web.multipart.MultipartFile;

public class MediaDto {

    private Long id;
    private String title;
    private int media_type_id;
    private int genre_id;
    private String summary;
    private String banner_url;
    private String thumbnail_url;
    private MultipartFile banner_file;
    private MultipartFile thumbnail_file;

    public MediaDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMedia_type_id() {
        return media_type_id;
    }

    public void setMedia_type_id(int media_type_id) {
        this.media_type_id = media_type_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getSummary() {
        return summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public MultipartFile getBanner_file() {
        return banner_file;
    }

    public void setBanner_file(MultipartFile banner_file) {
        this.banner_file = banner_file;
    }

    public MultipartFile getThumbnail_file() {
        return thumbnail_file;
    }

    public void setThumbnail_file(MultipartFile thumbnail_file) {
        this.thumbnail_file = thumbnail_file;
    }
}
