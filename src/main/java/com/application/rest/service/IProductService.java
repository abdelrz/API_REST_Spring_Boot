package com.application.rest.service;

import com.application.rest.controllers.dto.ProductDTO;
import com.application.rest.entities.Product;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<ProductDTO> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
    void save(Product product);
    void deleteById(Long id);

    ProductDTO toDTO(Product product);
    Product fromDTO(ProductDTO productDTO);
    List<ProductDTO> toDTOList(List<Product> products);

    ResponseEntity<?> saveProduct(ProductDTO productDTO) throws URISyntaxException;
    ResponseEntity<?> updateProduct(Long id, ProductDTO productDTO);
}
