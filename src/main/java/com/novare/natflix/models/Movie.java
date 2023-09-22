package com.novare.natflix.models;

import javax.persistence.*;

@Entity(name = "movies")
@Table(name = "movies")
public class Movie{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String director;
    private float rating;
    private String videoCode;

    @OneToOne(targetEntity = Media.class,cascade = CascadeType.ALL)
    private Media media;


    public Movie() {
    }

    public Movie(Long id, String director, float rating, String videoCode, Media media) {
        this.id = id;
        this.director = director;
        this.rating = rating;
        this.videoCode = videoCode;
        this.media = media;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
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





}
