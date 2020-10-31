package com.GeeksClassesAssignment.RandomImage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Component
@Document(collection = "RandomImages")
public @Data class ImageDetails {
    @Id
    String _id;
    @JsonIgnore byte[] blob;
    String imageUrl;

    public ImageDetails(String _id, byte[] blob, String imageUrl) {
        this._id = _id;
        this.blob = blob;
        this.imageUrl = imageUrl;
    }

    public ImageDetails() {

    }
}
