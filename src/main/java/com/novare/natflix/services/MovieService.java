package com.novare.natflix.services;

import com.novare.natflix.dtos.MovieDto;
import com.novare.natflix.exceptions.ResourceNotFoundException;
import com.novare.natflix.mappers.MovieMapper;
import com.novare.natflix.models.Media;
import com.novare.natflix.models.Movie;
import com.novare.natflix.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.novare.natflix.utilities.Constants.NO_IMAGE;

@Service
public class MovieService {

    private final MovieRepository repository;
    private final ImageService imageService;

    public MovieService(MovieRepository repository,ImageService imageService) {
        this.repository = repository;
        this.imageService = imageService;
    }

    public Long addMovie(MovieDto movieDto){
        Movie movie = MovieMapper.toMovie(movieDto,imageService);
        return repository.save(movie).getId();
    }

    public List<MovieDto> getMovies(){
        return repository
                .findAll()
                .stream()
                .map(MovieMapper::toMovieDto)
                .toList();
    }

    public Long updateMovie(MovieDto movieDto){
        Movie movie = MovieMapper.toMovie(movieDto,imageService);
        Movie existingMovie = repository.findById(movieDto.getId()).orElseThrow(()->new ResourceNotFoundException(movieDto.getId().toString()));

        Media updatedMedia = getUpdatedMedia(movie, existingMovie);

        movie.setMedia(updatedMedia);
        return repository.save(movie).getId();
    }

    private static Media getUpdatedMedia(Movie movie, Movie existingMovie) {
        Media updatedMedia = movie.getMedia();
        Media existingMedia = existingMovie.getMedia();
        updatedMedia.setId(existingMedia.getId());

        if(updatedMedia.getBannerUrl().equals(NO_IMAGE)) updatedMedia.setBannerUrl(existingMedia.getBannerUrl());
        if(updatedMedia.getThumbnailUrl().equals(NO_IMAGE)) updatedMedia.setThumbnailUrl(existingMedia.getThumbnailUrl());
        return updatedMedia;
    }

    public void deleteMovie(Long id) {
        repository.deleteById(id);
    }

    public MovieDto getSingleMovieByMediaId(Long id) {
        Movie movie = repository.findByMediaId(id);
        if(movie==null) throw new ResourceNotFoundException(id.toString());
        return MovieMapper.toMovieDto(movie);
    }
}
