package com.GeeksClassesAssignment.RandomImage.service;

import com.GeeksClassesAssignment.RandomImage.DbInterface.ImageRepository;
import com.GeeksClassesAssignment.RandomImage.models.ImageDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomImageService {
    @Autowired
    ImageRepository imageRepository;

    public ImageDetails saveImage(ImageDetails imageDetails)
    {
        return imageRepository.save(imageDetails);
    }
    public Optional<ImageDetails> getImageById(String id)
    {
        return imageRepository.findById(id);
    }
    public List<ImageDetails> getAllImagesIdAndLink()
    {
        return imageRepository.findAll();
    }

    public ImageDetails getImageFromPicSum(String id) throws URISyntaxException {
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

       return this.saveImage(imageDetails);
    }
    public Optional<ImageDetails> getImage(String id) throws URISyntaxException {
        Optional<ImageDetails> imageDetails=this.getImageById(id);
        if(imageDetails.isPresent())
        {
            return imageDetails;
        }
        else
        {
            imageDetails= Optional.ofNullable(this.getImageFromPicSum(id));
        }

        return imageDetails;
    }
    public List<ImageDetails> getAllImageDetails()  {
      return this.getAllImagesIdAndLink();
    }
}
