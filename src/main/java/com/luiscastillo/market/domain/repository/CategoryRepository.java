package com.luiscastillo.market.domain.repository;

import com.luiscastillo.market.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository
{
    List<Category> getAll();
    Optional<Category> getById(int id);
    Category save(Category category);
    void delete(int categoryId);
}
