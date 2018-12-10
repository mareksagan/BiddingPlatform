package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "client_transactions_enum", schema = "public", catalog = "biddingplatformdb")
public class ClientTransactionsEnumEntity {
    private String transactionKind;
    private int id;

    @Basic
    @Column(name = "transaction_kind")
    public String getTransactionKind() {
        return transactionKind;
    }

    public void setTransactionKind(String transactionKind) {
        this.transactionKind = transactionKind;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientTransactionsEnumEntity that = (ClientTransactionsEnumEntity) o;

        if (id != that.id) return false;
        if (transactionKind != null ? !transactionKind.equals(that.transactionKind) : that.transactionKind != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionKind != null ? transactionKind.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
