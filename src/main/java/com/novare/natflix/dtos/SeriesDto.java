package com.novare.natflix.dtos;

import com.novare.natflix.models.Media;

public class SeriesDto extends MediaDto{

    private Long id;
    private Media media;


    public SeriesDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

}
