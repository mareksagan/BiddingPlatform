package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "payout")
public class Payout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "bank_name", nullable = false, length = 50)
    private String bankName;

    @Column(name = "swift_nr", nullable = false)
    private long swiftNr;

    @OneToOne
    @JoinColumn(name="id", insertable = false, updatable = false)
    private User client;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "amount", nullable = false, precision = 0)
    private double amount;

    public UUID getId() {
        return id;
    }

    public Payout setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public Payout setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public long getSwiftNr() {
        return swiftNr;
    }

    public Payout setSwiftNr(long swiftNr) {
        this.swiftNr = swiftNr;
        return this;
    }

    public User getClient() {
        return client;
    }

    public Payout setClient(User client) {
        this.client = client;
        return this;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Payout setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Payout setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payout that = (Payout) o;

        if (swiftNr != that.swiftNr) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (int) (swiftNr ^ (swiftNr >>> 32));
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
