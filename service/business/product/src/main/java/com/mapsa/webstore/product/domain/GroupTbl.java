package com.mapsa.webstore.product.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "GROUP_TBL")
public class GroupTbl {
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    private Category categoryByCategoryId;
}
