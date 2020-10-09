package com.mapsa.webstore.product.domain2;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CART_ITEM", schema = "STORE", catalog = "")
public class CartItem {
    private long id;
    private Product productByProductId;
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
        CartItem cartItem = (CartItem) o;
        return id == cartItem.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
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
