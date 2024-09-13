package com.schroh.gym.webapp.gym_webapp.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Temporal(TemporalType.DATE) // Solo se anota la fecha sin la hora
    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Payment() {
    }

    public Payment(Double amount, Client client, Long id, Date paymentDate) {
        this.amount = amount;
        this.client = client;
        this.id = id;
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
