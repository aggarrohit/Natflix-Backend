package com.novare.natflix.models;

import javax.persistence.*;

@Entity(name = "series")
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    @OneToOne(targetEntity = Media.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Media media;


    public Series() {
    }

    public Series(Long id, Media media
    ) {
        this.id = id;
        this.media = media;
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
