package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "watchlist")
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name= "id", insertable = false, updatable = false)
    private User client;

    @OneToOne
    @JoinColumn(name= "id", insertable = false, updatable = false)
    private Item item;

    public User getClient() {
        return client;
    }

    public Watchlist setClient(User client) {
        this.client = client;
        return this;
    }

    public Item getItem() {
        return item;
    }

    public Watchlist setItemId(Item item) {
        this.item = item;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Watchlist setId(UUID id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Watchlist that = (Watchlist) o;

        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
