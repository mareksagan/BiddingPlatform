package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "fee", schema = "public", catalog = "biddingplatformdb")
public class FeeEntity {
    private UUID id;
    private UUID categoryId;
    private double percentage;

    @Id
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category_id", nullable = false)
    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "percentage", nullable = false, precision = 0)
    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeeEntity feeEntity = (FeeEntity) o;

        if (Double.compare(feeEntity.percentage, percentage) != 0) return false;
        if (id != null ? !id.equals(feeEntity.id) : feeEntity.id != null) return false;
        if (categoryId != null ? !categoryId.equals(feeEntity.categoryId) : feeEntity.categoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        temp = Double.doubleToLongBits(percentage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
