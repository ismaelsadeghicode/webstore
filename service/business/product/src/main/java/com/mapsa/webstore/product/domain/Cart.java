package com.mapsa.webstore.product.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Table("cart")
@Accessors(chain = true)
public class Cart {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private Long total;
}
