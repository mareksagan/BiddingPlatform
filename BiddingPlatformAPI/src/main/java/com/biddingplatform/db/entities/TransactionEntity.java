package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "transaction", schema = "public", catalog = "biddingplatformdb")
public class TransactionEntity {
    private UUID paymentId;
    private UUID id;
    private UUID cartId;
    private boolean finished;

    @Basic
    @Column(name = "payment_id", nullable = false)
    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cart_id", nullable = false)
    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    @Basic
    @Column(name = "finished", nullable = false)
    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (finished != that.finished) return false;
        if (paymentId != null ? !paymentId.equals(that.paymentId) : that.paymentId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cartId != null ? !cartId.equals(that.cartId) : that.cartId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId != null ? paymentId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (cartId != null ? cartId.hashCode() : 0);
        result = 31 * result + (finished ? 1 : 0);
        return result;
    }
}
