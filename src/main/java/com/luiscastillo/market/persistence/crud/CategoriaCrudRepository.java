package com.luiscastillo.market.persistence.crud;

import com.luiscastillo.market.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer>
{
}
