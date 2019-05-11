package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "blacklist", schema = "public", catalog = "biddingplatformdb")
public class BlacklistEntity {
    private UUID clientId;
    private UUID blacklistedClientId;
    private UUID id;

    @Basic
    @Column(name = "client_id", nullable = false)
    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "blacklisted_client_id", nullable = false)
    public UUID getBlacklistedClientId() {
        return blacklistedClientId;
    }

    public void setBlacklistedClientId(UUID blacklistedClientId) {
        this.blacklistedClientId = blacklistedClientId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlacklistEntity that = (BlacklistEntity) o;

        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;
        if (blacklistedClientId != null ? !blacklistedClientId.equals(that.blacklistedClientId) : that.blacklistedClientId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (blacklistedClientId != null ? blacklistedClientId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
