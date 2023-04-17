package by.it.academy.shopS.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String model;
    private String specifications;
    private Integer guarantee;
    private BigDecimal price;
    private Integer quantity;
}
