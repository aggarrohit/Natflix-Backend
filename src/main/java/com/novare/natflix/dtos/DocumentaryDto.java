package com.novare.natflix.dtos;

import com.novare.natflix.models.Media;

public class DocumentaryDto extends MediaDto{

    private Long id;

    private String narrator;
    private String video_code;

    private Media media;

    public Long getId() {
        return id;
    }


    public DocumentaryDto() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public String getVideo_code() {
        return video_code;
    }

    public void setVideo_code(String video_code) {
        this.video_code = video_code;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

}
