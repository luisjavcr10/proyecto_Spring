package com.luiscastillo.market.web.controller;

import com.luiscastillo.market.domain.Client;
import com.luiscastillo.market.domain.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController
{
    @Autowired
    private ClientService clientService;

    @Operation(summary = "Obtener todos los clientes", description = "Retorna una lista de todos los clientes registrados en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista dee clientes obtenida exitosamente")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un cliente por su ID", description = "Se obtiene un cliente en especifico basado en su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente obtenido exitosamente"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @GetMapping("/{id}")
    public  ResponseEntity<Client> getById(
            @Parameter(description = "ID del cliente a buscar", example = "7092608")
            @PathVariable("id") String clientId){
        return clientService.getById(clientId)
                .map(client -> new ResponseEntity<>(client,HttpStatus.OK ))
                        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Registrar un cliente", description = "Registra un nuevo cliente en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente registrado exitosamente")
    })
    @PostMapping("/save")
    public ResponseEntity<Client> save(
            @Parameter(description = "Cliente a ingresar")
            @RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar un cliente", description = "Elimina el registro de un cliente en especifico segun su ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") String clientId){
        if (clientService.delete(clientId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
