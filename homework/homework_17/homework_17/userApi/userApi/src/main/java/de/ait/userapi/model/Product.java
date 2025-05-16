package de.ait.userapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter


@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private Long id;
    private String title;
    BigDecimal price;
}
