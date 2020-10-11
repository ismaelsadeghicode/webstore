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
@Table(name = "FACTOR")
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Factor {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    @Column(name = "TOTAL")
    private Long total;
    @ManyToOne
    @JoinColumn(name = "ORDER_TBL_ID", referencedColumnName = "ID")
    private OrderTbl orderTblByOrderTblId;

}
