package com.luiscastillo.market.domain.repository;

import com.luiscastillo.market.domain.Product;
import com.luiscastillo.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface  ProductRepository
{
    List<Product> getAll();
    Optional<Product> getById(int productId);
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> minimumStock(int stock,boolean active);
    Product save(Product product);
    void delete(int productId);

}
