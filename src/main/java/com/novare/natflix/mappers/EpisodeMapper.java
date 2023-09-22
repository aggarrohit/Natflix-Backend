package com.novare.natflix.mappers;

import com.novare.natflix.dtos.EpisodeDto;
import com.novare.natflix.models.Episode;
import com.novare.natflix.services.ImageService;

public class EpisodeMapper {

    private EpisodeMapper(){}

    public static Episode toEpisode(EpisodeDto episodeDto, ImageService imageService){

        Episode episode = new Episode();

        episode.setEpisodeNumber(episodeDto.getEpisode_number());
        episode.setId(episodeDto.getId());
        episode.setSummary(episodeDto.getSummary());
        episode.setTitle(episodeDto.getTitle());
        episode.setThumbnailUrl(imageService.addImagePost(episodeDto.getThumbnail_file()));
        episode.setSeasonNumber(episodeDto.getSeason_number());
        episode.setVideoCode(episodeDto.getVideo_code());
        
        return  episode;
    }

    public static EpisodeDto toEpisodeDto(Episode episode){
        EpisodeDto episodeDto = new EpisodeDto();

        episodeDto.setTitle(episode.getTitle());
        episodeDto.setSeason_number(episode.getSeasonNumber());
        episodeDto.setSummary(episode.getSummary());
        episodeDto.setThumbnail_url(episode.getThumbnailUrl());
        episodeDto.setEpisode_number(episode.getEpisodeNumber());
        episodeDto.setVideo_code(episode.getVideoCode());
        episodeDto.setId(episode.getId());

        return  episodeDto;
    }

}
