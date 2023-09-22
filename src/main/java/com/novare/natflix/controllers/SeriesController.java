package com.novare.natflix.controllers;

import com.novare.natflix.dtos.EpisodeDto;
import com.novare.natflix.dtos.SeriesDto;
import com.novare.natflix.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tv-series")
public class SeriesController {

    @Autowired
    SeriesService seriesService;

    ResponseEntity<Long> addSeries(@ModelAttribute SeriesDto seriesDto){
        return ResponseEntity.ok().body(seriesService.addSeries(seriesDto));
    }

    ResponseEntity<Long> updateSeries(@ModelAttribute SeriesDto seriesDto, @PathVariable Long id){
        seriesDto.setId(id);
        return ResponseEntity.ok().body(seriesService.updateSeries(seriesDto));
    }

    ResponseEntity<String> deleteSeries(@PathVariable Long id){
        seriesService.deleteSeries(id);
        return ResponseEntity.ok().body("deleted");
    }

    ResponseEntity<List<SeriesDto>> getAllSeries(){
        return ResponseEntity.ok().body(seriesService.getSeriess());
    }


    @GetMapping("/{id}")
    ResponseEntity<List<EpisodeDto>> getSeriesEpisodes(@PathVariable Long id){
        if(getUserRole().equals("ROLE_ADMIN")){
            return ResponseEntity.ok().body(seriesService.getEpisodesBySeriesId(id));
        }
        else
        if(getUserRole().equals("ROLE_CUSTOMER")){
            return ResponseEntity.ok().body(seriesService.getEpisodesByMediaId(id));
        }

        return null;
    }

    @PostMapping("/{id}")
    ResponseEntity<EpisodeDto> addSeriesEpisode(@PathVariable Long id, @ModelAttribute EpisodeDto episodeDto){
        return ResponseEntity.ok().body(seriesService.addEpisode(episodeDto,id));
    }


    @PutMapping("/episode/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<Long> updateEpisode(@ModelAttribute EpisodeDto episodeDto, @PathVariable Long id){
        episodeDto.setId(id);
        return ResponseEntity.ok().body(seriesService.updateSeriesEpisode(episodeDto));
    }

    @DeleteMapping("/episode/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<String> deleteEpisode(@PathVariable Long id){
        seriesService.deleteSeriesEpisode(id);
        return ResponseEntity.ok().body("deleted");
    }


    private String getUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            StringBuilder roles = new StringBuilder();
            authentication.getAuthorities().forEach(authority -> {
                roles.append(authority.getAuthority());
            });

            return roles.toString();
        } else {
            return "User is not authenticated";
        }
    }

}
