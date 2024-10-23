package com.luiscastillo.market.domain.service;

import com.luiscastillo.market.domain.Product;
import com.luiscastillo.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getById(int productId){
        return productRepository.getById(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        return getById(productId).map(p ->{
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
