package com.luiscastillo.market.persistence.mapper;

import com.luiscastillo.market.domain.Client;
import com.luiscastillo.market.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper
{
    @Mappings({
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "nombre", target = "firstName"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "email", target = "email"),
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "compras", ignore = true)
    Cliente toCliente(Client client);
}
