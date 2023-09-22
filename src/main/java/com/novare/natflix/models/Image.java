package com.novare.natflix.models;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Entity(name = "images")
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private Blob image;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
