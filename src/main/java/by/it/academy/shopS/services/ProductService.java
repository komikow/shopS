package by.it.academy.shopS.services;

import by.it.academy.shopS.dto.ProductRequest;
import by.it.academy.shopS.dto.ProductResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getProducts(Pageable pageable);

    void deleteProduct(int id);

    ProductResponse productUpdateGuarantee(int id, int price);

    ProductResponse createProduct(ProductRequest productRequest);
}
