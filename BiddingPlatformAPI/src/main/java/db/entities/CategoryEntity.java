package db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_category", schema = "public", catalog = "biddingplatformdb")
public class CategoryEntity {
    private int category;

    @Id
    @Column(name = "category")
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (category != that.category) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return category;
    }
}
