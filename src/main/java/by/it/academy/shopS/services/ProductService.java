package by.it.academy.shopS.services;

import by.it.academy.shopS.dto.ProductRequest;
import by.it.academy.shopS.dto.ProductResponse;
import by.it.academy.shopS.entities.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getProducts(Pageable pageable);

    ProductResponse createProduct(ProductRequest productRequest);
}
