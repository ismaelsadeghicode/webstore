package com.mapsa.webstore.product.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table("cart")
public class Cart {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private Long total;
}
