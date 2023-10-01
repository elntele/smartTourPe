package com.pe.smartTourPe.repository;

import com.pe.smartTourPe.model.TourismSpotModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TourismSpotRepository extends CrudRepository<TourismSpotModel, Integer> {
    public List<TourismSpotModel> findByName(String name);
}
