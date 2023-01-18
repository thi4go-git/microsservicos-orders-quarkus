package org.acme.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class ProductDTO {
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
}
