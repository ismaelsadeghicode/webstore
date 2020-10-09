package com.mapsa.webstore.product.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Factor {
    private long id;
    private Long total;
    private OrderTbl orderTblByOrderTblId;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TOTAL")
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factor factor = (Factor) o;
        return id == factor.id &&
                Objects.equals(total, factor.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total);
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_TBL_ID", referencedColumnName = "ID")
    public OrderTbl getOrderTblByOrderTblId() {
        return orderTblByOrderTblId;
    }

    public void setOrderTblByOrderTblId(OrderTbl orderTblByOrderTblId) {
        this.orderTblByOrderTblId = orderTblByOrderTblId;
    }
}
