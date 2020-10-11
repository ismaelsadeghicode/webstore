package com.mapsa.webstore.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "CATEGORY")
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "DISCRIPTION")
    private String discription;
    @OneToMany
    private List<GroupTbl> groupTbls;
}
