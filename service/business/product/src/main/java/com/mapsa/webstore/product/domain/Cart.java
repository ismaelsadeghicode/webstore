package com.mapsa.webstore.product.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Accessors(chain = true)
@Data
@Entity
public class Cart {
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "TOTAL")
    private long total;
}
