package by.it.academy.shopS.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
public class ProductRequest {
    @NotBlank
    private String model;
    @NotBlank
    private String specifications;
    @NotNull
    private Integer monthsWarranty;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer quantity;
}
