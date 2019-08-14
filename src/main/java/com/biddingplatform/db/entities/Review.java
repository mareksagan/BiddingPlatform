package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name="id", insertable = false, updatable = false)
    private Item item;

    @OneToOne
    @JoinColumn(name="id", insertable = false, updatable = false)
    private User reviewer;

    @Column(name = "text", nullable = false, length = 400)
    private String text;

    @Column(name = "stars", nullable = false)
    private int stars;

    public Item getItem() {
        return item;
    }

    public Review setItemId(Item item) {
        this.item = item;
        return this;
    }

    public User getReviewer() {
        return reviewer;
    }

    public Review setReviewerId(User reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public String getText() {
        return text;
    }

    public Review setText(String text) {
        this.text = text;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Review setId(UUID id) {
        this.id = id;
        return this;
    }

    public int getStars() {
        return stars;
    }

    public Review setStars(int stars) {
        this.stars = stars;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review that = (Review) o;

        if (stars != that.stars) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (reviewer != null ? !reviewer.equals(that.reviewer) : that.reviewer != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (reviewer != null ? reviewer.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + stars;
        return result;
    }
}
