package com.luiscastillo.market.persistence;

import com.luiscastillo.market.domain.Product;
import com.luiscastillo.market.domain.repository.ProductRepository;
import com.luiscastillo.market.persistence.crud.ProductoCrudRepository;
import com.luiscastillo.market.persistence.entity.Producto;
import com.luiscastillo.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Indica que esta clase interactua con la base de datos
@Repository
public class ProductoRepository implements ProductRepository
{
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    //Get all products
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    //Get a product by his id
    @Override
    public Optional<Product> getById(int productId){
        Optional<Producto> producto = productoCrudRepository.findById(productId);
        return producto.map(p -> productMapper.toProduct(p));
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> minimumStock(int stock, boolean active) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(stock, active);
        return productos.map(prods -> productMapper.toProducts(prods) );
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}
