package com.novare.natflix.utilities;

public enum MediaType {
    SERIES(1),
    MOVIES(2),
    DOCUMENTARIES(3);

    private final int mediaTypeValue; // Associated value for each enum constant

    // Constructor to initialize the associated value
    MediaType(int mediaTypeValue) {
        this.mediaTypeValue = mediaTypeValue;
    }

    public int getMediaTypeValue() {
        return mediaTypeValue;
    }
}
