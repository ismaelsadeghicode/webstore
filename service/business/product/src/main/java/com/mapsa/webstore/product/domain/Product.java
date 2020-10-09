package com.mapsa.webstore.product.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    private long id;
    private String name;
    private Long price;
    private String avatar;
    private Long stock;
    private GroupTbl groupTblByGroupId;

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
    @Column(name = "PRICE")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "AVATAR")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "STOCK")
    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(avatar, product.avatar) &&
                Objects.equals(stock, product.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, avatar, stock);
    }

    @ManyToOne
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    public GroupTbl getGroupTblByGroupId() {
        return groupTblByGroupId;
    }

    public void setGroupTblByGroupId(GroupTbl groupTblByGroupId) {
        this.groupTblByGroupId = groupTblByGroupId;
    }
}
