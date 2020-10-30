package com.GeeksClassesAssignment.RandomImage.Resources;

import com.GeeksClassesAssignment.RandomImage.DbInterface.ImageRepository;
import com.GeeksClassesAssignment.RandomImage.models.ImageDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ThreadLocalRandom;


@RestController
class RandomImageController {
    @Autowired
    ImageRepository imageRepository;

    @GetMapping(value = "/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] GetRandomImage(@PathVariable String id) throws URISyntaxException {
        RestTemplate restTemplate= new RestTemplate();


        int rand_int1 = ThreadLocalRandom.current().nextInt(100);
        rand_int1+=Integer.parseInt(id);
        String randomId=Integer.toString(rand_int1);


        String baseUrlPicsum="https://picsum.photos/id/";
        String url=baseUrlPicsum+randomId+"/200/200";
        URI reqUrl=new URI(url);
        byte[] response
                = restTemplate.getForObject(reqUrl, byte[].class);

        ImageDetails imageDetails=new ImageDetails(id,response,url);

        System.out.println(imageDetails.get_id()+" "+imageDetails.getImageUrl());
//        try{
//            if(response.getStatusCode()==HttpStatus.OK)
//            {
//                System.out.println("Body Image "+ response.getBody());
//                return response.getBody().getBytes();
//            }
//            else
//                throw new NoSuchFieldException("Invalid Id");
//        }
//        catch (NoSuchFieldException e)
//        {
//            return e.getMessage().getBytes();
//        }
        return response;

    }

}