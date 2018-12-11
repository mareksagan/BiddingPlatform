package db.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bid", schema = "public", catalog = "biddingplatformdb")
public class BidEntity {
    private Timestamp timestamp;
    private float amount;
    private Object id;

    @Basic
    @Column(name = "timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name = "amount")
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Id
    @Column(name = "id")
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BidEntity bidEntity = (BidEntity) o;

        if (Float.compare(bidEntity.amount, amount) != 0) return false;
        if (timestamp != null ? !timestamp.equals(bidEntity.timestamp) : bidEntity.timestamp != null) return false;
        if (id != null ? !id.equals(bidEntity.id) : bidEntity.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timestamp != null ? timestamp.hashCode() : 0;
        result = 31 * result + (amount != +0.0f ? Float.floatToIntBits(amount) : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
