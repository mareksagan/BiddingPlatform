package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "blacklist")
public class Blacklist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name= "id", insertable = false, updatable = false)
    private User client;

    @OneToOne
    @JoinColumn(name= "id", insertable = false, updatable = false)
    private User blacklistedClient;

    public User getClient() {
        return client;
    }

    public Blacklist setClient(User client) {
        this.client = client;
        return this;
    }

    public User getBlacklistedClient() {
        return blacklistedClient;
    }

    public Blacklist setBlacklistedClient(User blacklistedClient) {
        this.blacklistedClient = blacklistedClient;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Blacklist setId(UUID id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Blacklist that = (Blacklist) o;

        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (blacklistedClient != null ? !blacklistedClient.equals(that.blacklistedClient) : that.blacklistedClient != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + (blacklistedClient != null ? blacklistedClient.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
