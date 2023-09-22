package com.novare.natflix.mappers;

import com.novare.natflix.dtos.DocumentaryDto;
import com.novare.natflix.models.Documentary;
import com.novare.natflix.models.Media;
import com.novare.natflix.services.ImageService;
import com.novare.natflix.utilities.MediaType;

public class DocumentaryMapper {

    private DocumentaryMapper() {
    }

    public static Documentary toDocumentary(DocumentaryDto documentaryDto, ImageService imageService){
        Documentary documentary = new Documentary();
        documentary.setNarrator(documentaryDto.getNarrator());
        documentary.setVideoCode(documentaryDto.getVideo_code());
        documentary.setId(documentaryDto.getId());


        Media media = MediaMapper.toMedia(documentaryDto,imageService);

        media.setMediaTypeId(MediaType.DOCUMENTARIES.getMediaTypeValue());

        documentary.setMedia(media);

        return  documentary;
    }

    public static DocumentaryDto toDocumentaryDto(Documentary documentary){
        DocumentaryDto documentaryDto = new DocumentaryDto();

        documentaryDto.setVideo_code(documentary.getVideoCode());
        documentaryDto.setSummary(documentary.getMedia().getSummary());
        documentaryDto.setGenre_id(documentary.getMedia().getGenreId());
        documentaryDto.setBanner_url(documentary.getMedia().getBannerUrl());
        documentaryDto.setMedia_type_id(documentary.getMedia().getMediaTypeId());
        documentaryDto.setThumbnail_url(documentary.getMedia().getThumbnailUrl());

        documentaryDto.setId(documentary.getId());
        documentaryDto.setTitle(documentary.getMedia().getTitle());
        documentaryDto.setNarrator(documentary.getNarrator());

        return  documentaryDto;
    }

}
