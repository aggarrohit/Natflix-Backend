package com.novare.natflix.mappers;

import com.novare.natflix.dtos.MovieDto;
import com.novare.natflix.models.Media;
import com.novare.natflix.models.Movie;
import com.novare.natflix.services.ImageService;
import com.novare.natflix.utilities.MediaType;

public class MovieMapper {

    private MovieMapper(){}

    public static Movie toMovie(MovieDto movieDto, ImageService imageService){
        Movie movie = new Movie();
        movie.setDirector(movieDto.getDirector());
        movie.setRating(movieDto.getRating());
        movie.setVideoCode(movieDto.getVideo_code());
        movie.setId(movieDto.getId());


        Media media = MediaMapper.toMedia(movieDto,imageService);

        media.setMediaTypeId(MediaType.MOVIES.getMediaTypeValue());

        movie.setMedia(media);

        return  movie;
    }

    public static MovieDto toMovieDto(Movie movie){
        MovieDto movieDto = new MovieDto();

        movieDto.setVideo_code(movie.getVideoCode());
        movieDto.setSummary(movie.getMedia().getSummary());
        movieDto.setGenre_id(movie.getMedia().getGenreId());
        movieDto.setBanner_url(movie.getMedia().getBannerUrl());
        movieDto.setMedia_type_id(movie.getMedia().getMediaTypeId());
        movieDto.setThumbnail_url(movie.getMedia().getThumbnailUrl());

        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getMedia().getTitle());
        movieDto.setDirector(movie.getDirector());
        movieDto.setRating(movie.getRating());

        return  movieDto;
    }

}
