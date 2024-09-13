package com.schroh.gym.webapp.gym_webapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String url_gif;

    @ManyToMany(mappedBy = "exercises")
    private List<Routine> routines = new ArrayList<>();

    public Exercise() {
    }

    public Exercise(Long id, String name, String description, List<Routine> routines, String url_gif) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.routines = routines;
        this.url_gif = url_gif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }

    public String getUrl_gif() {
        return url_gif;
    }

    public void setUrl_gif(String url_gif) {
        this.url_gif = url_gif;
    }
}
