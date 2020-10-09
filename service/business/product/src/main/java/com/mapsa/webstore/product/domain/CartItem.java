package com.mapsa.webstore.product.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;
@Data
@Accessors(chain = true)
@Entity
@Table(name = "CART_ITEM")
public class CartItem {
    @Id
    @Column(name = "ID")
    private long id;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    private Product productByProductId;
    @ManyToOne
    @JoinColumn(name = "CART_ID", referencedColumnName = "ID", nullable = false)
    private Cart cartByCartId;
}
