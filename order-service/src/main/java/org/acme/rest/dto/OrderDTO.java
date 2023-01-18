package org.acme.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    @NotNull(message = "{campo.customer_id.nullo}")
    private Long customer_id;

    @NotNull(message = "{campo.product_id.nullo}")
    private Long product_id;

    private String customer_name;

    @NotNull(message = "{campo.order_value.nullo}")
    private BigDecimal order_value;
}
