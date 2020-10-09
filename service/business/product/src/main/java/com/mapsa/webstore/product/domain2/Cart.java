package com.mapsa.webstore.product.domain2;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cart {
    private long id;
    private long total;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TOTAL")
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id &&
                total == cart.total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total);
    }
}
