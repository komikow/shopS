package by.it.academy.shopS.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MODEL", nullable = false, length = 100)
    private String model;

    @Column(name = "SPECIFICATIONS", nullable = false, length = 200)
    private String specifications;

    @Column(name = "GUARANTEE", nullable = false, length = 100)
    private Integer monthsWarranty;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "QUANTITY", nullable = false, length = 100)
    private Integer quantity;
}
