package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "amount", nullable = false, precision = 0)
    private double amount;

    @Column(name = "client_id", nullable = false)
    private UUID clientId;

    @Column(name = "item_id", nullable = false)
    private UUID itemId;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Bid setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Bid setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Bid setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getClientId() {
        return clientId;
    }

    public Bid setClientId(UUID clientId) {
        this.clientId = clientId;
        return this;
    }

    public UUID getItemId() {
        return itemId;
    }

    public Bid setItemId(UUID itemId) {
        this.itemId = itemId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bidEntity = (Bid) o;

        if (Double.compare(bidEntity.amount, amount) != 0) return false;
        if (timestamp != null ? !timestamp.equals(bidEntity.timestamp) : bidEntity.timestamp != null) return false;
        if (id != null ? !id.equals(bidEntity.id) : bidEntity.id != null) return false;
        if (clientId != null ? !clientId.equals(bidEntity.clientId) : bidEntity.clientId != null) return false;
        if (itemId != null ? !itemId.equals(bidEntity.itemId) : bidEntity.itemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = timestamp != null ? timestamp.hashCode() : 0;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        return result;
    }
}
