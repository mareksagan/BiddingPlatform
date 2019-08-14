package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "number", nullable = false)
    private long number;

    @Column(name = "ccv", nullable = false, length = 3)
    private String ccv;

    @Column(name = "exp_month", nullable = false)
    private int expMonth;

    @Column(name = "exp_year", nullable = false)
    private int expYear;

    public long getNumber() {
        return number;
    }

    public Card setNumber(long number) {
        this.number = number;
        return this;
    }

    public String getCcv() {
        return ccv;
    }

    public Card setCcv(String ccv) {
        this.ccv = ccv;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Card setId(UUID id) {
        this.id = id;
        return this;
    }

    public int getExpYear() {
        return expYear;
    }

    public Card setExpYear(int expYear) {
        this.expYear = expYear;
        return this;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public Card setExpMonth(int expMonth) {
        this.expMonth = expMonth;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card that = (Card) o;

        if (number != that.number) return false;
        if (expYear != that.expYear) return false;
        if (expMonth != that.expMonth) return false;
        if (ccv != null ? !ccv.equals(that.ccv) : that.ccv != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (number ^ (number >>> 32));
        result = 31 * result + (ccv != null ? ccv.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + expYear;
        result = 31 * result + expMonth;
        return result;
    }
}
