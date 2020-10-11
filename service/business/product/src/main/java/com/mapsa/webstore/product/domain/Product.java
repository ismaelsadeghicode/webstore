package com.mapsa.webstore.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "PRODUCT")
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
       private GroupTbl groupTbl ;
    @ManyToMany
    //@JoinColumn(nullable = true)
    private List<Cart> carts;
}
