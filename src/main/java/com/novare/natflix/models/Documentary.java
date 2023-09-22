package com.novare.natflix.models;

import javax.persistence.*;

@Entity(name = "documentaries")
@Table(name = "documentaries")

public class Documentary {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String narrator;
    private String videoCode;

    @OneToOne(targetEntity = Media.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "media_id")
    private Media media;


    public Documentary() {
    }

    public Documentary(Long id, String narrator, String videoCode, Media media) {
        this.id = id;
        this.narrator = narrator;
        this.videoCode = videoCode;
        this.media = media;
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

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Long getId() {
        return id;
    }


}
