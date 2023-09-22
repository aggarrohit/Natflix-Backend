package com.novare.natflix.controllers;

import com.novare.natflix.dtos.DocumentaryDto;
import com.novare.natflix.dtos.MediaDto;
import com.novare.natflix.dtos.MovieDto;
import com.novare.natflix.dtos.SeriesDto;
import com.novare.natflix.mappers.MediaMapper;
import com.novare.natflix.models.Media;
import com.novare.natflix.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    MediaService mediaService;

    @GetMapping("/{id}")
    ResponseEntity<MediaDto> getMedia(@PathVariable Long id){
        return ResponseEntity.ok().body(mediaService.getSingleMedia(id));
    }


    @GetMapping
    ResponseEntity<List<MediaDto>> getAllMedias(){

        List<MediaDto> mediaDtoList = new ArrayList<>();

        for (Media media:mediaService.getMedias()){
            mediaDtoList.add(MediaMapper.toMediaDto(media));
        }

        return ResponseEntity.ok().body(mediaDtoList);
    }



    @Autowired
    DocumentaryController documentaryController;
    @PostMapping("/documentaries")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Long> addDocumentary(@ModelAttribute DocumentaryDto documentaryDto){
        return documentaryController.addDocumentary(documentaryDto);
    }

    @PutMapping("/documentaries/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Long> updateDocumentary(@ModelAttribute DocumentaryDto documentaryDto, @PathVariable Long id){
        return documentaryController.updateDocumentary(documentaryDto,id);
    }

    @DeleteMapping("/documentaries/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<String> deleteDocumentary(@PathVariable Long id){
        return documentaryController.deleteDocumentary(id);
    }

    @GetMapping("/documentaries")
    ResponseEntity<List<DocumentaryDto>> getAllDocumentaries(){
        return documentaryController.getAllDocumentaries();
    }


    @Autowired
    SeriesController seriesController;
    @PostMapping("/tv-series")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Long> addSeries(@ModelAttribute SeriesDto seriesDto){
        return seriesController.addSeries(seriesDto);
    }

    @PutMapping("/tv-series/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Long> updateSeries(@ModelAttribute SeriesDto seriesDto, @PathVariable Long id){
        return seriesController.updateSeries(seriesDto,id);
    }

    @DeleteMapping("/tv-series/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<String> deleteSeries(@PathVariable Long id){
        return seriesController.deleteSeries(id);
    }

    @GetMapping("/tv-series")
    ResponseEntity<List<SeriesDto>> getAllSeries(){
        return seriesController.getAllSeries();
    }






    @Autowired
    MovieController movieController;
    @PostMapping("/movies")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Long> addMovie(@ModelAttribute MovieDto movieDto){
        return movieController.addMovie(movieDto);
    }

    @PutMapping("/movies/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Long> updateMovie(@ModelAttribute MovieDto movieDto, @PathVariable Long id){
        return movieController.updateMovie(movieDto,id);
    }

    @DeleteMapping("/movies/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<String> deleteMovie(@PathVariable Long id){
        return movieController.deleteMovie(id);
    }

    @GetMapping("/movies")
    ResponseEntity<List<MovieDto>> getAllMovies(){
        return movieController.getAllMovies();
    }


    @GetMapping("/search")
    ResponseEntity<List<MediaDto>> searchText(@RequestParam String search_text){
        return ResponseEntity.ok().body(mediaService.searchText(search_text));
    }

}
