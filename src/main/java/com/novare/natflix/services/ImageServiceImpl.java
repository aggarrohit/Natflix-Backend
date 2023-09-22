package com.novare.natflix.services;

import com.novare.natflix.models.Image;
import com.novare.natflix.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import static com.novare.natflix.utilities.Constants.NO_IMAGE;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image viewById(long id) {
        return imageRepository.findById(id).get();
    }

    @Override
    public String addImagePost(MultipartFile file)
    {
        if(file==null) return NO_IMAGE;
        try {
        byte[] bytes;

            bytes = file.getBytes();

        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Image image = new Image();
        image.setImage(blob);
        Image addedImage = create(image);
        return String.valueOf(addedImage.getId());
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
