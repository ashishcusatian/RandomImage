package com.GeeksClassesAssignment.RandomImage.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Component
@Document(collection = "ImageDetails")
public @Data class ImageDetails {
    @Id
    String _id;
    byte[] blob;
    String imageUrl;

    public ImageDetails(String _id, byte[] blob, String imageUrl) {
        this._id = _id;
        this.blob = blob;
        this.imageUrl = imageUrl;
    }

    public ImageDetails() {

    }
}
