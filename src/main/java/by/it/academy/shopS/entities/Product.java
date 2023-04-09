package by.it.academy.shopS.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "\"PRODUCT_ID\"", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    @Column(name = "\"MODEL\"", nullable = false, length = 100)
    private String model;

    @Column(name = "\"SPECIFICATIONS\"", nullable = false, length = 300)
    private String specifications;

    @Column(name = "\"GUARANTEE\"", nullable = false, length = 10)
    private int guarantee;

    @Column(name = "\"PRICE\"", nullable = false, length = 100)
    private int price;

    @Column(name = "\"QUANTITY\"", nullable = false, length = 100)
    private int quantity;
}
