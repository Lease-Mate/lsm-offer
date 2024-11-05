package com.lsm.ws.offer.context.image;

import com.lsm.ws.offer.configuration.exception.NoSuchImageException;
import com.lsm.ws.offer.configuration.exception.UnsupportedImageFormatException;
import com.lsm.ws.offer.domain.image.ImageRepository;
import com.lsm.ws.offer.domain.offer.OfferImage;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    private static final List<String> SUPPORTED_IMAGE_FORMATS = List.of("jpg", "jpeg");

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String addImage(String offerId, MultipartFile image) throws IOException {
        var imageFormat = FilenameUtils.getExtension(image.getOriginalFilename());
        if (!SUPPORTED_IMAGE_FORMATS.contains(imageFormat)) {
            throw new UnsupportedImageFormatException(String.join(", ", SUPPORTED_IMAGE_FORMATS));
        }
        var offerImage = new OfferImage(
                UUID.randomUUID().toString(),
                offerId,
                image.getBytes(),
                FilenameUtils.getExtension(image.getOriginalFilename()),
                1 //todo: implement sorting images per offer
        );
        return imageRepository.save(offerImage)
                              .id();
    }

    public OfferImage getImage(String imageId) {
        return imageRepository.getById(imageId)
                              .orElseThrow(NoSuchImageException::new);
    }
}
