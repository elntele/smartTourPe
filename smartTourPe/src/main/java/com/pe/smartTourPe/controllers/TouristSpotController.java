package com.pe.smartTourPe.controllers;

import com.pe.smartTourPe.model.TourismSpotModel;
import com.pe.smartTourPe.requestmodel.PostTourismSpotRequest;
import com.pe.smartTourPe.requestmodel.PutTourismSpotRequest;
import com.pe.smartTourPe.services.TourismSpotService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@RequestMapping("/touristSpot")
public class TouristSpotController {
    private TourismSpotService tourismSpotService;

    public TouristSpotController(TourismSpotService t) {
        tourismSpotService = t;
    }

    @GetMapping("/getAll")
    public List getTouristSpot() {
        return tourismSpotService.getAllSpot();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTouristSpot(@RequestBody @NotNull PostTourismSpotRequest postTourismSpotRequest) {
        var t = postTourismSpotRequest.toModel();
        tourismSpotService.createTourismSpot(t);
    }

    @GetMapping("/{id}")
    public TourismSpotModel getTourismSpotById(@PathVariable String id) {
        return tourismSpotService.getTouristSpot(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTouristSpot(@PathVariable String id, @RequestBody @NotNull PutTourismSpotRequest putTourismSpotRequest) throws Exception {
        tourismSpotService.updateSpotById(putTourismSpotRequest.toModel(Integer.parseInt(id)));
    }


    @GetMapping
    public List<TourismSpotModel> getTourismSpotByName(@RequestParam String name) {
        return tourismSpotService.getTouristSpotByName(name);
    }

    @GetMapping("/partname")
    public List<TourismSpotModel> getTouristSpotSearch(@RequestParam String name) {
        return tourismSpotService.getTourismSpotModelSearchByName(name);
    }


    @GetMapping("/spotSortedByPoints")
    public List<TourismSpotModel> getSpotSortedByPoints() {
        return tourismSpotService.getTourismSpotSortedForPoints();
    }

    @GetMapping("/spotSortedByPointsSeparatedByType")
    public List<TourismSpotModel> getTourismSpotSortedForPointsAndSeparatedByType(
            @RequestParam String type
    ) {
        return tourismSpotService.getTourismSpotSortedForPointsAndSeparatedForType(type);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) throws Exception {
        tourismSpotService.deleteSpotById(Integer.parseInt(id));
    }


}
