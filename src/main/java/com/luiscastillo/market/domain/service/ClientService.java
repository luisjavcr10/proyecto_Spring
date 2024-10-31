package com.luiscastillo.market.domain.service;

import com.luiscastillo.market.domain.Client;
import com.luiscastillo.market.domain.repository.ClientRepository;
import com.luiscastillo.market.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService
{
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getById(String clientId) {
        return clientRepository.getById(clientId);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public boolean delete(String clientId) {
        return getById(clientId)
                .map(c ->
                {
                    clientRepository.delete(clientId);
                    return true;
                })
                .orElse(false);
    }
}
