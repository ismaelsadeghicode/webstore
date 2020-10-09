package com.mapsa.webstore.product.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ORDER_TBL")
public class OrderTbl {
    private long id;
    private Cart cartByCartId;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderTbl orderTbl = (OrderTbl) o;
        return id == orderTbl.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "CART_ID", referencedColumnName = "ID", nullable = false)
    public Cart getCartByCartId() {
        return cartByCartId;
    }

    public void setCartByCartId(Cart cartByCartId) {
        this.cartByCartId = cartByCartId;
    }
}
