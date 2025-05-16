package de.ait.userapi.mappers;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductMapper {
    ProductResponseDto toResponseDto(Product product);
   List<ProductResponseDto> toResponseDtoList(List<Product> products);
   Product fromRquestDto(ProductRequestDto dto);
}
