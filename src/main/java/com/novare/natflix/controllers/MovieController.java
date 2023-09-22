package com.novare.natflix.controllers;

import com.novare.natflix.dtos.MovieDto;
import com.novare.natflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService  movieService;


    ResponseEntity<Long> addMovie(@ModelAttribute MovieDto movieDto){
        return ResponseEntity.ok().body(movieService.addMovie(movieDto));
    }

    ResponseEntity<Long> updateMovie(@ModelAttribute MovieDto movieDto, @PathVariable Long id){
        movieDto.setId(id);
        return ResponseEntity.ok().body(movieService.updateMovie(movieDto));
    }

    ResponseEntity<String> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok().body("deleted");
    }

    @GetMapping("/")
    ResponseEntity<List<MovieDto>> getAllMovies(){
        return ResponseEntity.ok().body(movieService.getMovies());
    }


    @GetMapping("/{id}")
    ResponseEntity<MovieDto> getMovie(@PathVariable Long id){
        return ResponseEntity.ok().body(movieService.getSingleMovieByMediaId(id));
    }

}
