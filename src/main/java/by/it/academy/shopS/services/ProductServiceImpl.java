package by.it.academy.shopS.services;

import by.it.academy.shopS.dto.ProductRequest;
import by.it.academy.shopS.dto.ProductResponse;
import by.it.academy.shopS.entities.Product;
import by.it.academy.shopS.mapper.ProductMapper;
import by.it.academy.shopS.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable).stream()
                .map(productMapper::buildProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponse productUpdateGuaranteePeriod(Long id, Integer monthsWarranty) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Can't find user with id %s", id)));
        product.setMonthsWarranty(monthsWarranty);
        productRepository.save(product);
        return productMapper.buildProductResponse(product);
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productMapper.buildProduct(productRequest);
        productRepository.save(product);
        return productMapper.buildProductResponse(product);
    }
}
