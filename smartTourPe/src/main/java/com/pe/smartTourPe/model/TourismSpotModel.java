package com.pe.smartTourPe.model;

import jakarta.persistence.*;


@Entity(name = "tourismSpotModel")
public class TourismSpotModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id=0;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String description;
    @Column
    private Integer points;

    @Column(length = 20000)
    private String image;

    public TourismSpotModel(
            Integer id,
            String name,
            String type,
            String description,
            Integer points,
            String image
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.points = points;
        this.image=image;
    }

    public TourismSpotModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
