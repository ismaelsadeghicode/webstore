package com.mapsa.webstore.product.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Data
@Accessors(chain = true)
@Entity
public class Factor {
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "TOTAL")
    private Long total;
    @ManyToOne
    @JoinColumn(name = "ORDER_TBL_ID", referencedColumnName = "ID")
    private OrderTbl orderTblByOrderTblId;

}
