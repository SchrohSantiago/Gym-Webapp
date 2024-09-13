package com.schroh.gym.webapp.gym_webapp.entities;

import com.schroh.gym.webapp.gym_webapp.entities.enums.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Se utiliza para formar una unica tabla jerarquica e implementar el discriminator, en este caso es la tabla usuario que discriminara entre las entidades User o Admin
@DiscriminatorColumn(name = "user_type") // nombre de la columna discriminatoria
abstract public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotacion clave para los ID
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String phone;

    @Column(name = "user_type", nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING) // Guarda al ENUM en tipo String, crucial !
    private UserType userType;

    public User() {

    }

    public User(String dni, Long id, String lastName, String name, String phone, UserType userType) {
        this.dni = dni;
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.phone = phone;
        this.userType = userType;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "dni='" + dni + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", userType=" + userType +
                '}';
    }
}
