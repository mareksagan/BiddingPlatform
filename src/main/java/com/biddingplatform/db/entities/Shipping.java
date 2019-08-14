package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "company", nullable = false, length = 80)
    private String company;

    @Column(name = "amount", nullable = true, precision = 0)
    private Double amount;

    @Column(name = "days", nullable = false)
    private int days;

    public UUID getId() {
        return id;
    }

    public Shipping setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Shipping setCompany(String company) {
        this.company = company;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Shipping setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public int getDays() {
        return days;
    }

    public Shipping setDays(int days) {
        this.days = days;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shipping that = (Shipping) o;

        if (days != that.days) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + days;
        return result;
    }
}
