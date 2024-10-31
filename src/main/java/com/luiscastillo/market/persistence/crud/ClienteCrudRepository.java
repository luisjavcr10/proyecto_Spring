package com.luiscastillo.market.persistence.crud;

import com.luiscastillo.market.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String>
{
}
