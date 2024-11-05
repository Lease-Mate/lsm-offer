package com.lsm.ws.offer.context.image;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Images services")
@RestController
@RequestMapping("/v1/api/offer/image")
public class ImageEndpoint {

    private static final String GET_IMAGE = "Get image";
    private static final String GET_IMAGE_DESC = "returns specific offer image";
    private final ImageService imageService;

    public ImageEndpoint(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value = "/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Operation(summary = GET_IMAGE, description = GET_IMAGE_DESC)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageId) {
        var image = imageService.getImage(imageId);
        return ResponseEntity.ok(image.image());
    }
}
