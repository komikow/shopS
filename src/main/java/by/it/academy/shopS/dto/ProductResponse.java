package by.it.academy.shopS.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private int product_id;
    private String model;
    private String specifications;
    private int guarantee;
    private int price;
    private int quantity;
}
