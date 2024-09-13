package com.schroh.gym.webapp.gym_webapp.entities;

import com.schroh.gym.webapp.gym_webapp.entities.enums.UserType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("CLIENT")
public class Client extends User {

    @ManyToMany // Muchos clientes tienen muchas rutinas, y muchas rutinas estan asignadas a muchos clientes
    @JoinTable( // Union de tablas entre la tabla User y Routines (Creacion se tabla de relacion)
            name = "client_routines", // nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "routine_id")
    )
    private List<Routine> routines = new ArrayList<>();

    // Un cliente tiene muchos pagos
    @OneToMany(mappedBy = "client") // El mappedBy establece la ForeginKey en la tabla Payment, es decir que Payment es duenia de la relacion
    private List<Payment> payments = new ArrayList<>();

    public Client() {
    }

    public Client(List<Payment> payments, List<Routine> routines) {
        this.payments = payments;
        this.routines = routines;
    }

    public Client(String dni, Long id, String lastName, String name, String phone, UserType userType, List<Payment> payments, List<Routine> routines) {
        super(dni, id, lastName, name, phone, userType);
        this.payments = payments;
        this.routines = routines;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }
}
