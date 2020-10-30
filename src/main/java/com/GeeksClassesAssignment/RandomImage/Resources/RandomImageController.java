package com.GeeksClassesAssignment.RandomImage.Resources;

import com.GeeksClassesAssignment.RandomImage.DbInterface.ImageRepository;
import com.GeeksClassesAssignment.RandomImage.models.ImageDetails;
import com.GeeksClassesAssignment.RandomImage.service.RandomImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;


@RestController
class RandomImageController {

    @Autowired
    RandomImageService randomImageService;

    @GetMapping(value = "/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] GetRandomImage(@PathVariable String id) throws URISyntaxException {
        Optional<ImageDetails> imageDetails=randomImageService.getImage(id);
        if(imageDetails.isPresent())
        return imageDetails.get().getBlob();
        throw new NoSuchElementException();
    }


    @GetMapping(value = "/images",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ImageDetails GetAllImagesInformation()  {
        return (ImageDetails) randomImageService.getAllImageDetails();
    }


}