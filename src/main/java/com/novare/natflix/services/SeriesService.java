package com.novare.natflix.services;

import com.novare.natflix.dtos.EpisodeDto;
import com.novare.natflix.dtos.SeriesDto;
import com.novare.natflix.exceptions.ResourceNotFoundException;
import com.novare.natflix.mappers.EpisodeMapper;
import com.novare.natflix.mappers.SeriesMapper;
import com.novare.natflix.models.Episode;
import com.novare.natflix.models.Media;
import com.novare.natflix.models.Series;
import com.novare.natflix.repositories.EpisodeRepository;
import com.novare.natflix.repositories.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.novare.natflix.utilities.Constants.NO_IMAGE;

@Service
public class SeriesService {

    private final SeriesRepository repository;
    private final ImageService imageService;

    private final EpisodeRepository episodeRepository;

    public SeriesService(SeriesRepository repository, EpisodeRepository episodeRepository,ImageService imageService) {
        this.repository = repository;
        this.episodeRepository = episodeRepository;
        this.imageService=imageService;
    }

    public Long addSeries(SeriesDto seriesDto){
        Series series = SeriesMapper.toSeries(seriesDto,imageService);
        return repository.save(series).getId();
    }

    public List<SeriesDto> getSeriess(){
        return repository
                .findAll()
                .stream()
                .map(SeriesMapper::toSeriesDto)
                .toList();
    }

    public List<EpisodeDto> getEpisodesBySeriesId(Long id) {
        return episodeRepository
                .findBySeriesId(id)
                .stream()
                .map(EpisodeMapper::toEpisodeDto)
                .toList();
    }

    public List<EpisodeDto> getEpisodesByMediaId(Long id) {
        List<Episode> episodeList = episodeRepository.findBySeries_Media_Id(id);
        if(episodeList==null) throw new ResourceNotFoundException(id.toString());

        return episodeList
                .stream()
                .map(EpisodeMapper::toEpisodeDto)
                .toList();
    }

    public EpisodeDto addEpisode(EpisodeDto episodeDto,Long seriesId){

        Episode episode = EpisodeMapper.toEpisode(episodeDto,imageService);
        Series series = repository.findById(seriesId).orElse(null);
        if(series==null) throw new ResourceNotFoundException(seriesId.toString());
        episode.setSeries(series);

        return EpisodeMapper.toEpisodeDto(episodeRepository.save(episode));
    }

    public Long updateSeries(SeriesDto seriesDto){
        Series series = SeriesMapper.toSeries(seriesDto,imageService);
        Series existingseries = repository.findById(seriesDto.getId())
                .orElseThrow(()->new ResourceNotFoundException(seriesDto.getId().toString()));
        Media updatedMedia = getUpdatedMedia(series, existingseries);

        series.setMedia(updatedMedia);
        series.setId(existingseries.getId());
        return repository.save(series).getId();
    }

    private static Media getUpdatedMedia(Series series, Series existingseries) {
        Media updatedMedia = series.getMedia();
        Media existingMedia = existingseries.getMedia();
        updatedMedia.setId(existingMedia.getId());

        if(updatedMedia.getBannerUrl().equals(NO_IMAGE)) updatedMedia.setBannerUrl(existingMedia.getBannerUrl());
        if(updatedMedia.getThumbnailUrl().equals(NO_IMAGE)) updatedMedia.setThumbnailUrl(existingMedia.getThumbnailUrl());
        return updatedMedia;
    }

    public void deleteSeries(Long id) {
        repository.deleteById(id);
    }

    public Long updateSeriesEpisode(EpisodeDto episodeDto) {
        Episode episode = EpisodeMapper.toEpisode(episodeDto,imageService);
        Episode existingEpisode = episodeRepository.findById(episodeDto.getId())
                .orElseThrow(()->new ResourceNotFoundException(episodeDto.getId().toString()));
        episode.setSeries(existingEpisode.getSeries());
        if(episode.getThumbnailUrl().equals(NO_IMAGE)) episode.setThumbnailUrl(existingEpisode.getThumbnailUrl());

        return episodeRepository.save(episode).getId();
    }

    public void deleteSeriesEpisode(Long id) {
        episodeRepository.deleteById(id);
    }
}
