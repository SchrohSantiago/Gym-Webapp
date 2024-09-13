package com.schroh.gym.webapp.gym_webapp.entities;

import com.schroh.gym.webapp.gym_webapp.entities.enums.UserType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User{
    public Admin() {
    }

    public Admin(String dni, Long id, String lastName, String name, String phone, UserType userType) {
        super(dni, id, lastName, name, phone, userType);
    }

}
