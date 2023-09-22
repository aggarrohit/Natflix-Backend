package com.novare.natflix.services;

import com.novare.natflix.models.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ImageService {

    public Image create(Image image);
    public Image viewById(long id);
    public String addImagePost(MultipartFile file);

}
