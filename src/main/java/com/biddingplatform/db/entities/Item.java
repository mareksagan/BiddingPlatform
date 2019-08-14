package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private User seller;

    @Column(name = "desc", nullable = false, length = 200)
    private String desc;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Category category;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "price", nullable = false, precision = 0)
    private double price;

    @Column(name = "due", nullable = false)
    private Timestamp due;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "height", nullable = true, precision = 0)
    private Double height;

    @Column(name = "length", nullable = true, precision = 0)
    private Double length;

    @Column(name = "width", nullable = true, precision = 0)
    private Double width;

    @Column(name = "weight", nullable = true, precision = 0)
    private Double weight;

    @Column(name = "allow_bidding", nullable = false)
    private boolean allowBidding;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "photo")
    private List<Photo> photos = new ArrayList<Photo>();

    public UUID getId() {
        return id;
    }

    public Item setId(UUID id) {
        this.id = id;
        return this;
    }

    public User getSeller() {
        return seller;
    }

    public Item setSeller(User seller) {
        this.seller = seller;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Item setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Item setCategory(Category category) {
        this.category = category;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Item setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Item setPrice(double price) {
        this.price = price;
        return this;
    }

    public Timestamp getDue() {
        return due;
    }

    public Item setDue(Timestamp due) {
        this.due = due;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Item setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public Item setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public Item setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getWidth() {
        return width;
    }

    public Item setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public Item setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public boolean isAllowBidding() {
        return allowBidding;
    }

    public Item setAllowBidding(boolean allowBidding) {
        this.allowBidding = allowBidding;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item that = (Item) o;

        if (amount != that.amount) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (active != that.active) return false;
        if (allowBidding != that.allowBidding) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (seller != null ? !seller.equals(that.seller) : that.seller != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (due != null ? !due.equals(that.due) : that.due != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + amount;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (due != null ? due.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (allowBidding ? 1 : 0);
        return result;
    }
}
