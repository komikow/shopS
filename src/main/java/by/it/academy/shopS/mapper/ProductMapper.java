package by.it.academy.shopS.mapper;

import by.it.academy.shopS.dto.ProductRequest;
import by.it.academy.shopS.dto.ProductResponse;
import by.it.academy.shopS.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse buildProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .model(product.getModel())
                .specifications(product.getSpecifications())
                .guarantee(product.getMonthsWarranty())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public Product buildProduct(ProductRequest productRequest) {
        return Product.builder()
                .model(productRequest.getModel())
                .specifications(productRequest.getSpecifications())
                .monthsWarranty(productRequest.getMonthsWarranty())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
    }
}
