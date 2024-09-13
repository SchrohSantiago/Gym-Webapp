package com.schroh.gym.webapp.gym_webapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routine")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "routines")
    private List<Client> clients = new ArrayList<>();

    @ManyToMany // Muchas rutinas tienen muchos ejericios y muchos ejercicios estan asignadas a muchas rutinas
    @JoinTable(
            name = "routine_exercise", // Nombre de la tabla de union
            joinColumns = @JoinColumn(name = "routine_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises = new ArrayList<>();


    public Routine() {
    }

    public Routine(List<Client> clients, List<Exercise> exercises, Long id, String name) {
        this.clients = clients;
        this.exercises = exercises;
        this.id = id;
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
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
}
