package com.luiscastillo.market.persistence;

import com.luiscastillo.market.domain.Client;
import com.luiscastillo.market.domain.repository.ClientRepository;
import com.luiscastillo.market.persistence.crud.ClienteCrudRepository;
import com.luiscastillo.market.persistence.entity.Cliente;
import com.luiscastillo.market.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClienteCrudRepository clientCrudRepository;
    @Autowired
    private ClientMapper clienteMapper;

    @Override
    public List<Client> getAll() {
        return clienteMapper.toClients((List<Cliente>) clientCrudRepository.findAll());
    }

    @Override
    public Optional<Client> getById(String clientId) {
        return clientCrudRepository.findById(clientId).map(c -> clienteMapper.toClient(c));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = clienteMapper.toCliente(client);
        return clienteMapper.toClient(clientCrudRepository.save(cliente));
    }

    @Override
    public void delete(String clientId) {
        clientCrudRepository.deleteById(clientId);
    }
}
