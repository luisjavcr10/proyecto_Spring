package com.luiscastillo.market.persistence;

import com.luiscastillo.market.domain.Category;
import com.luiscastillo.market.domain.repository.CategoryRepository;
import com.luiscastillo.market.persistence.crud.CategoriaCrudRepository;
import com.luiscastillo.market.persistence.entity.Categoria;
import com.luiscastillo.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository
{
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        return categoryMapper.toCategories((List<Categoria>) categoriaCrudRepository.findAll());
    }

    @Override
    public Optional<Category> getById(int categoryId)
    {
        Optional<Categoria> categoria = categoriaCrudRepository.findById(categoryId);
        return categoria.map(c -> categoryMapper.toCategory(c));
    }

    @Override
    public Category save(Category category)
    {
        Categoria categoria = categoryMapper.toCategoria(category);
        categoriaCrudRepository.save(categoria);
        return categoryMapper.toCategory(categoria);
    }

    @Override
    public void delete(int categoryId)
    {
        categoriaCrudRepository.deleteById(categoryId);
    }
}
