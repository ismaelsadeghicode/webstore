package com.mapsa.webstore.product.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ORDER_TBL")
public class OrderTbl {
    @Id
    @Column(name = "ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "CART_ID", referencedColumnName = "ID", nullable = false)
    private Cart cartByCartId;

}
