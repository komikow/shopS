package by.it.academy.shopS.repositories;

import by.it.academy.shopS.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
