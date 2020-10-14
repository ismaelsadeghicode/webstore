package com.mapsa.webstore.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "ORDER_TBL")
@Component
@AllArgsConstructor
@NoArgsConstructor
public class OrderTbl {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Cart cart;
    @ManyToOne(fetch =FetchType.EAGER)
    private User user;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}
