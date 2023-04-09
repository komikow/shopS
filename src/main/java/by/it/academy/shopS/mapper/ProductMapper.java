package by.it.academy.shopS.mapper;

import by.it.academy.shopS.dto.ProductRequest;
import by.it.academy.shopS.dto.ProductResponse;
import by.it.academy.shopS.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse buildProductResponse(Product product) {
        return ProductResponse.builder()
                .product_id(product.getProduct_id())
                .model(product.getModel())
                .specifications(product.getSpecifications())
                .guarantee(product.getGuarantee())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public Product buildProduct(ProductRequest productRequest) {
        return Product.builder()
                .model(productRequest.getModel())
                .specifications(productRequest.getSpecifications())
                .guarantee(productRequest.getGuarantee())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
    }
}
