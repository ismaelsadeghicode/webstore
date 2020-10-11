package com.mapsa.webstore.product.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Accessors(chain = true)
@Entity
@Table(name = "USER")
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private  String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany
    private List<OrderTbl> orderTbl;

    }
