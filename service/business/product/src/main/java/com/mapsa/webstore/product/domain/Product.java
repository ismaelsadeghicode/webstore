package com.mapsa.webstore.product.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PRICE")
    private Long price;
    @Basic
    @Column(name = "AVATAR")
    private String avatar;
    @Basic
    @Column(name = "STOCK")
    private Long stock;
    @ManyToOne
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    private GroupTbl groupTblByGroupId;
}
