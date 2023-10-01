package com.pe.smartTourPe.requestmodel;

import com.pe.smartTourPe.model.TourismSpotModel;

public record PostTourismSpotRequest(
        String name,
        String type,
        String description,
        Integer points,
        String image
) {
    public TourismSpotModel toModel() {
        return new TourismSpotModel(
                0,
                name,
                type,
                description,
                points,
                image
        );
    }
}
