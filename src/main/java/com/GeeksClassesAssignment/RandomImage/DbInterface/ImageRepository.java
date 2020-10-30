package com.GeeksClassesAssignment.RandomImage.DbInterface;

import com.GeeksClassesAssignment.RandomImage.models.ImageDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ImageRepository extends MongoRepository<ImageDetails, String> {

//    @Query(fields="{ '_id' : 1, 'imageUrl' : 1}")
//    List<ImageDetails> findAllImages();

}
