package com.pe.smartTourPe.services;

import com.pe.smartTourPe.model.TourismSpotModel;
import com.pe.smartTourPe.repository.TourismSpotRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourismSpotService {
    private final TourismSpotRepository tourismSpotRepository;

    public TourismSpotService(TourismSpotRepository t) {
        tourismSpotRepository = t;

    }


    public List<TourismSpotModel> getAllSpot() {
        List<TourismSpotModel> spotList = new ArrayList<>();
        tourismSpotRepository.findAll().forEach(s -> {
                    spotList.add(s);
                }
        );
        return spotList;
    }

    public void createTourismSpot(TourismSpotModel t) {
        tourismSpotRepository.save(t);
    }

    public TourismSpotModel getTouristSpot(Integer id) {
        return tourismSpotRepository.findById(id).orElseThrow();
    }

    public void updateSpotById(@NotNull TourismSpotModel tourismSpotModel) throws Exception {
        int idInt = 0;
        idInt = tourismSpotModel.getId();
        if (!tourismSpotRepository.existsById(idInt)) {
            throw new Exception("not found");
        } else {
            tourismSpotRepository.save(tourismSpotModel);
        }
    }

    public void deleteSpotById(Integer id) throws Exception {
        if (tourismSpotRepository.existsById(id)) {
            tourismSpotRepository.deleteById(id);
        } else {
            throw new Exception("not found");
        }
    }

    public List<TourismSpotModel> getTouristSpotByName(String name) {
        return tourismSpotRepository.findByName(name);
    }

    public List<TourismSpotModel> getTourismSpotModelSearchByName(String name) {
        var l = new ArrayList<TourismSpotModel>();
        tourismSpotRepository.findAll().forEach(l::add);
        return l.stream().filter(p->p.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }
public List<TourismSpotModel> getTourismSpotSortedForPoints(){
        var l = new ArrayList<TourismSpotModel>();
        tourismSpotRepository.findAll().forEach(l::add);
        return l.stream().sorted((s1, s2)->s1.getPoints().compareTo(s2.getPoints())).toList();
}


    public List<TourismSpotModel> getTourismSpotSortedForPointsAndSeparatedForType(String type){
        var l = new ArrayList<TourismSpotModel>();
        tourismSpotRepository.findAll().forEach(l::add);
        return l.stream().filter(s->s.getType().toLowerCase().contains(type.toLowerCase())).sorted((s1, s2)->s1.getPoints().compareTo(s2.getPoints())).toList();
    }


}
