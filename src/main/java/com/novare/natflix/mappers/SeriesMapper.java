package com.novare.natflix.mappers;

import com.novare.natflix.dtos.SeriesDto;
import com.novare.natflix.models.Media;
import com.novare.natflix.models.Series;
import com.novare.natflix.services.ImageService;
import com.novare.natflix.utilities.MediaType;

public class SeriesMapper {

    private SeriesMapper(){}

    public static Series toSeries(SeriesDto seriesDto, ImageService imageService){
        Series series = new Series();

        Media media = MediaMapper.toMedia(seriesDto,imageService);

        media.setMediaTypeId(MediaType.SERIES.getMediaTypeValue());

        series.setMedia(media);

        return  series;
    }

    public static SeriesDto toSeriesDto(Series series){
        SeriesDto seriesDto = new SeriesDto();

        seriesDto.setSummary(series.getMedia().getSummary());
        seriesDto.setGenre_id(series.getMedia().getGenreId());
        seriesDto.setBanner_url(series.getMedia().getBannerUrl());
        seriesDto.setMedia_type_id(series.getMedia().getMediaTypeId());
        seriesDto.setThumbnail_url(series.getMedia().getThumbnailUrl());
        seriesDto.setTitle(series.getMedia().getTitle());

        seriesDto.setId(series.getId());

        return  seriesDto;
    }

}
