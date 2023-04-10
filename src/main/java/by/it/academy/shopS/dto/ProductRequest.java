package by.it.academy.shopS.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class ProductRequest {
    @NotBlank
    private String model;
    @NotBlank
    private String specifications;
    @NotBlank
    private int guarantee;
    @NotBlank
    private int price;
    @NotBlank
    private int quantity;
}
