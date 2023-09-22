package com.novare.natflix.services;

import com.novare.natflix.dtos.DocumentaryDto;
import com.novare.natflix.exceptions.ResourceNotFoundException;
import com.novare.natflix.mappers.DocumentaryMapper;
import com.novare.natflix.models.Documentary;
import com.novare.natflix.models.Media;
import com.novare.natflix.repositories.DocumentaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.novare.natflix.utilities.Constants.NO_IMAGE;

@Service
public class DocumentaryService {

    private final DocumentaryRepository repository;
    private final ImageService imageService;

    public DocumentaryService(DocumentaryRepository repository,ImageService imageService) {
        this.repository = repository;
        this.imageService = imageService;
    }

    public Long addDocumentary(DocumentaryDto documentaryDto){
        Documentary documentary = DocumentaryMapper.toDocumentary(documentaryDto,imageService);
        return repository.save(documentary).getId();
    }

    public List<DocumentaryDto> getDocumentaries(){
        return repository
                .findAll()
                .stream()
                .map(DocumentaryMapper::toDocumentaryDto)
                .toList();
    }

    public Long updateDocumentary(DocumentaryDto documentaryDto){
        Documentary documentary = DocumentaryMapper.toDocumentary(documentaryDto,imageService);
        Documentary existingDocumentary = repository.findById(documentaryDto.getId())
                    .orElseThrow(()->new ResourceNotFoundException(documentaryDto.getId().toString()));

        Media updatedMedia = getUpdatedMedia(documentary, existingDocumentary);

        documentary.setMedia(updatedMedia);

        return repository.save(documentary).getId();
    }

    private static Media getUpdatedMedia(Documentary documentary, Documentary existingDocumentary) {
        //setting media id from existing data
        Media updatedMedia = documentary.getMedia();
        Media existingMedia = existingDocumentary.getMedia();
        updatedMedia.setId(existingMedia.getId());

        //setting new image if updated image if passed, else setting old image
        if(updatedMedia.getBannerUrl().equals(NO_IMAGE)) updatedMedia.setBannerUrl(existingMedia.getBannerUrl());
        if(updatedMedia.getThumbnailUrl().equals(NO_IMAGE)) updatedMedia.setThumbnailUrl(existingMedia.getThumbnailUrl());
        return updatedMedia;
    }

    public void deleteDocumentary(Long id) {
        repository.deleteById(id);
    }

    public DocumentaryDto getSingleDocumentaryByMediaId(Long mediaId) {
        Documentary documentary =  repository.findByMediaId(mediaId);
        if(documentary==null) throw new ResourceNotFoundException(mediaId.toString());
        return DocumentaryMapper.toDocumentaryDto(documentary);
    }
}
