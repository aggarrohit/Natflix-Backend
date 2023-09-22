package com.novare.natflix.dtos;

import org.springframework.web.multipart.MultipartFile;

public class EpisodeDto {

    private Long id;
    private String title;
    private String summary;
    private String video_code;
    private int season_number;
    private int episode_number;

    private String thumbnail_url;

    private MultipartFile thumbnail_file;

    public EpisodeDto() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }


    public String getVideo_code() {
        return video_code;
    }

    public void setVideo_code(String video_code) {
        this.video_code = video_code;
    }

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    public MultipartFile getThumbnail_file() {
        return thumbnail_file;
    }

    public void setThumbnail_file(MultipartFile thumbnail_file) {
        this.thumbnail_file = thumbnail_file;
    }
}
