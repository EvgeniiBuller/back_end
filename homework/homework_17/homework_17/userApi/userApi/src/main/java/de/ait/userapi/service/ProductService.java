package de.ait.userapi.service;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto addProduct(ProductRequestDto dto);
    ProductResponseDto getProductById(Long id);
}
