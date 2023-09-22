package com.novare.natflix.mappers;

import com.novare.natflix.dtos.MediaDto;
import com.novare.natflix.models.Media;
import com.novare.natflix.services.ImageService;

public class MediaMapper {
    private MediaMapper() {}

    public static Media toMedia(MediaDto mediaDto, ImageService imageService){

        Media media = new Media();
        media.setBannerUrl(imageService.addImagePost(mediaDto.getBanner_file()));
        media.setMediaTypeId(mediaDto.getMedia_type_id());
        media.setGenreId(mediaDto.getGenre_id());
        media.setSummary(mediaDto.getSummary());
        media.setTitle(mediaDto.getTitle());
        media.setThumbnailUrl(imageService.addImagePost(mediaDto.getThumbnail_file()));
        media.setId(mediaDto.getId());
        
        return  media;
    }

    public static MediaDto toMediaDto(Media media){
        MediaDto mediaDto = new MediaDto();

        mediaDto.setTitle(media.getTitle());
        mediaDto.setGenre_id(media.getGenreId());
        mediaDto.setSummary(media.getSummary());
        mediaDto.setThumbnail_url(media.getThumbnailUrl());
        mediaDto.setBanner_url(media.getBannerUrl());
        mediaDto.setMedia_type_id(media.getMediaTypeId());
        mediaDto.setId(media.getId());

        return  mediaDto;
    }

}
