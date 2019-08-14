package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "fee")
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name= "id", insertable = false, updatable = false)
    private Category category;

    @Column(name = "percentage", nullable = false, precision = 0)
    private double percentage;

    public UUID getId() {
        return id;
    }

    public Fee setId(UUID id) {
        this.id = id;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Fee setCategory(Category category) {
        this.category = category;
        return this;
    }

    public double getPercentage() {
        return percentage;
    }

    public Fee setPercentage(double percentage) {
        this.percentage = percentage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fee feeEntity = (Fee) o;

        if (Double.compare(feeEntity.percentage, percentage) != 0) return false;
        if (id != null ? !id.equals(feeEntity.id) : feeEntity.id != null) return false;
        if (category != null ? !category.equals(feeEntity.category) : feeEntity.category != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        temp = Double.doubleToLongBits(percentage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
