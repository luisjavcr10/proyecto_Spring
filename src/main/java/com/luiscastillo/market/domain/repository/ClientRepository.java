package com.luiscastillo.market.domain.repository;

import com.luiscastillo.market.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository
{
    List<Client> getAll();
    Optional<Client> getById(String clientId);
    Client save(Client client);
    void delete(String clientId);
}
