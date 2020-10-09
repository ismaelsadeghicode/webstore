package com.mapsa.webstore.product.domain2;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GROUP_TBL", schema = "STORE", catalog = "")
public class GroupTbl {
    private long id;
    private String name;
    private String description;
    private Category categoryByCategoryId;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupTbl groupTbl = (GroupTbl) o;
        return id == groupTbl.id &&
                Objects.equals(name, groupTbl.name) &&
                Objects.equals(description, groupTbl.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
