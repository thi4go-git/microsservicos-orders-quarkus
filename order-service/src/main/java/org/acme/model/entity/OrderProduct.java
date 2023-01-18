package org.acme.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.acme.rest.dto.OrderDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long customer_id;

    @Column(nullable = false)
    private Long product_id;

    @Column(nullable = false)
    private String customer_name;

    @Column
    private BigDecimal order_value;

    //
    public OrderProduct(OrderDTO dto) {
        this.customer_id = dto.getCustomer_id();
        this.product_id = dto.getProduct_id();
        this.customer_name = dto.getCustomer_name();
        this.order_value = dto.getOrder_value();
    }

}
