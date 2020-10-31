package com.GeeksClassesAssignment.RandomImage.DbInterface;

import com.GeeksClassesAssignment.RandomImage.models.ImageDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends MongoRepository<ImageDetails, String> {


    @Query(value="{}", fields="{ blob : 0}")
     List<ImageDetails> findAll();

}
