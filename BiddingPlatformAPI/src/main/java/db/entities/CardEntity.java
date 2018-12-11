package db.entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "card", schema = "public", catalog = "biddingplatformdb")
public class CardEntity {
    private int number;
    private Time expDate;
    private int ccv;
    private Object id;

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "exp_date")
    public Time getExpDate() {
        return expDate;
    }

    public void setExpDate(Time expDate) {
        this.expDate = expDate;
    }

    @Basic
    @Column(name = "ccv")
    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
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

        CardEntity that = (CardEntity) o;

        if (number != that.number) return false;
        if (ccv != that.ccv) return false;
        if (expDate != null ? !expDate.equals(that.expDate) : that.expDate != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (expDate != null ? expDate.hashCode() : 0);
        result = 31 * result + ccv;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
