package com.novare.natflix.services;

import com.novare.natflix.dtos.MediaDto;
import com.novare.natflix.exceptions.ResourceNotFoundException;
import com.novare.natflix.mappers.MediaMapper;
import com.novare.natflix.models.Media;
import com.novare.natflix.repositories.MediaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MediaService {

    private final MediaRepository repository;

    public MediaService(MediaRepository repository) {
        this.repository = repository;
    }

    public List<Media> getMedias(){
        return  repository.findAll();
    }

    public MediaDto getSingleMedia(Long id){
        return MediaMapper.toMediaDto(repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id.toString())));
    }

    public List<MediaDto> searchText(String searchTerm){
        List<MediaDto> mediaDtoList = new ArrayList<>();

        for(Media media:repository.searchDocumentariesWithText(searchTerm)){
            mediaDtoList.add(MediaMapper.toMediaDto(media));
        }

        for(Media media:repository.searchMoviesWithText(searchTerm)){
            mediaDtoList.add(MediaMapper.toMediaDto(media));
        }

        for(Media media:repository.searchSeriesWithText(searchTerm)){
            mediaDtoList.add(MediaMapper.toMediaDto(media));
        }

        for(Media media:repository.searchSeriesEpisodesWithText(searchTerm)){
            MediaDto mediaDto = MediaMapper.toMediaDto(media);
            if(!doesListContainsSameMediaDto(mediaDtoList,mediaDto)) mediaDtoList.add(mediaDto);
        }

        return mediaDtoList;

    }

    private boolean doesListContainsSameMediaDto(List<MediaDto> mediaDtoList,MediaDto metchMediaDto){
        for (MediaDto mediaDto:mediaDtoList){
            if(Objects.equals(mediaDto.getId(), metchMediaDto.getId())){
                return true;
            }
        }
        return false;
    }
}
