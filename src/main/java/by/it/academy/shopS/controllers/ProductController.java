package by.it.academy.shopS.controllers;

import by.it.academy.shopS.dto.ProductRequest;
import by.it.academy.shopS.dto.ProductResponse;
import by.it.academy.shopS.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productServiceImpl;

    @GetMapping
    public List<ProductResponse> getProducts(Pageable pageable) {
        return productServiceImpl.getProducts(pageable);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        productServiceImpl.deleteProduct(id);
    }

    @PostMapping
    public ProductResponse createProduct(@Validated @RequestBody ProductRequest productRequest) {
        return productServiceImpl.createProduct(productRequest);
    }

    @PatchMapping("{id}/{monthsWarranty}")
    public ProductResponse productUpdateGuaranteePeriod(@PathVariable Long id, @PathVariable Integer monthsWarranty) {
        return productServiceImpl.productUpdateGuaranteePeriod(id, monthsWarranty);
    }
}
