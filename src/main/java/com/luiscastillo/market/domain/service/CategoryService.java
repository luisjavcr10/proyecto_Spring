package com.luiscastillo.market.domain.service;

import com.luiscastillo.market.domain.Category;
import com.luiscastillo.market.domain.repository.CategoryRepository;
import com.luiscastillo.market.persistence.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getById(int categoryId)
    {
        return categoryRepository.getById(categoryId);
    }

    public Category save(Category category)
    {
        return categoryRepository.save(category);
    }

    public boolean delete(int categoryId)
    {
        return getById(categoryId)
                .map(c -> {
                    categoryRepository.delete(categoryId);
                    return true;})
                .orElse(false);
    }

}
