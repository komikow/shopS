package by.it.academy.shopS.services;

import by.it.academy.shopS.dto.ProductRequest;
import by.it.academy.shopS.dto.ProductResponse;
import by.it.academy.shopS.entities.Product;
import by.it.academy.shopS.mapper.ProductMapper;
import by.it.academy.shopS.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable).stream()
                .map(productMapper::buildProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProductById(id);
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productMapper.buildProduct(productRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.buildProductResponse(savedProduct);
    }

    @Override
    public ProductResponse productUpdateGuarantee(int id, int price) {
        Product productById = productRepository.findProductById(id);
        productById.setPrice(price);
        return productMapper.buildProductResponse(productById);
    }
}
