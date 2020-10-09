package com.mapsa.webstore.product.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@Accessors(chain = true)
public class Category {
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "DISCRIPTION")
    private String discription;
}
