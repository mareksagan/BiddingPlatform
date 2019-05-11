package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "payout", schema = "public", catalog = "biddingplatformdb")
public class PayoutEntity {
    private UUID id;
    private String bankName;
    private long swiftNr;
    private UUID clientId;
    private Timestamp timestamp;
    private double amount;

    @Id
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bank_name", nullable = false, length = 50)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "swift_nr", nullable = false)
    public long getSwiftNr() {
        return swiftNr;
    }

    public void setSwiftNr(long swiftNr) {
        this.swiftNr = swiftNr;
    }

    @Basic
    @Column(name = "client_id", nullable = false)
    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "timestamp", nullable = false)
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 0)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayoutEntity that = (PayoutEntity) o;

        if (swiftNr != that.swiftNr) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;
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
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
