package com.mapsa.webstore.product.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "cart")
@Accessors(chain = true)
public class Factor  implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @OneToOne
    Order order;
    private  Long total;
}
