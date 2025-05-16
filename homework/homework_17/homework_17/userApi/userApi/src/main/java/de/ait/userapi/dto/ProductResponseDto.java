package de.ait.userapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString

public class ProductResponseDto {
    private Long id;
    private String title;
    BigDecimal price;
}
