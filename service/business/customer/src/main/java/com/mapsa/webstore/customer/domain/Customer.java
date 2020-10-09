package com.mapsa.webstore.customer.domain;

import com.mapsa.webstore.customer.dto.Location;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long code;
   /* @OneToOne(cascade = CascadeType.ALL)
    private Location locationId;*/
    private String type;
    private Long nationalCode;
    private ZonedDateTime insertLocalTime;
    private String remark;
    private Long lockVersion;
}
