package de.ait.userapi.repository;

import de.ait.userapi.model.Product;

import java.util.List ;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDB {
    private Long lastId = 5L;
    private static HashMap<Long, Product> map = new HashMap<>();
    static {
        map.put(1L, new Product(1L, "Bonbon", new BigDecimal("25.5")));
        map.put(2L, new Product(2L, "Soda", new BigDecimal("15.8")));
        map.put(3L, new Product(3L, "Brod", new BigDecimal("5.52")));
        map.put(4L, new Product(4L, "Milk", new BigDecimal("20")));
        map.put(5L, new Product(5L, "Pepper", new BigDecimal("8.5")));
    }

    public List<Product> findAll(){
        return map.values().stream().toList();
    }
    public Optional<Product> findById(Long id){
        return Optional.ofNullable(map.get(id));
    }
    public Product save(Product product){
        product.setId(lastId++);
        map.put(product.getId(), product);
        return product;
    }
}
