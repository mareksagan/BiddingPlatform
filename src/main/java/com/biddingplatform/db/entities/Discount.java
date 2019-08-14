package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "item_id", nullable = true)
    private UUID itemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Category category;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToOne
    @JoinColumn(name= "id", insertable = false, updatable = false)
    private User client;

    @Column(name = "percentage", nullable = false, precision = 0)
    private double percentage;

    public UUID getItemId() {
        return itemId;
    }

    public Discount setItemId(UUID itemId) {
        this.itemId = itemId;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Discount setCategoryId(Category category) {
        this.category = category;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Discount setActive(boolean active) {
        this.active = active;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Discount setId(UUID id) {
        this.id = id;
        return this;
    }

    public User getClient() {
        return client;
    }

    public Discount setClientId(User client) {
        this.client = client;
        return this;
    }

    public double getPercentage() {
        return percentage;
    }

    public Discount setPercentage(double percentage) {
        this.percentage = percentage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount that = (Discount) o;

        if (active != that.active) return false;
        if (Double.compare(that.percentage, percentage) != 0) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        temp = Double.doubleToLongBits(percentage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
