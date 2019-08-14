package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Cart cart;

    @Column(name = "finished", nullable = false)
    private boolean finished;

    public Payment getPayment() {
        return payment;
    }

    public Transaction setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Transaction setId(UUID id) {
        this.id = id;
        return this;
    }

    public Cart getCart() {
        return cart;
    }

    public Transaction setCart(Cart cart) {
        this.cart = cart;
        return this;
    }

    public boolean isFinished() {
        return finished;
    }

    public Transaction setFinished(boolean finished) {
        this.finished = finished;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (finished != that.finished) return false;
        if (payment != null ? !payment.equals(that.payment) : that.payment != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cart != null ? !cart.equals(that.cart) : that.cart != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = payment != null ? payment.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        result = 31 * result + (finished ? 1 : 0);
        return result;
    }
}
