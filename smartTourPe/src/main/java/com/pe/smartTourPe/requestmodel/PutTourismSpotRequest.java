package com.pe.smartTourPe.requestmodel;

import com.pe.smartTourPe.model.TourismSpotModel;

public record PutTourismSpotRequest(
        String name,
        String type,
        String description,
        Integer points,
        String image
) {
    public TourismSpotModel toModel(int id ) {
        return new TourismSpotModel(
                id,
                name,
                type,
                description,
                points,
                image
        );
    }
}
