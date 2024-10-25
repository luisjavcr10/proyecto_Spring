package com.luiscastillo.market.web.controller;

import com.luiscastillo.market.domain.Purchase;
import com.luiscastillo.market.domain.service.PurchaseService;
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
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Operation(summary = "Obtener todas las compras", description = "Retorna una lista de todas las compras realizadas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de compras obtenida exitosamente")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener compras por cliente", description = "Retorna una lista de compras realizadas por un cliente específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Compras del cliente obtenidas exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron compras para el cliente especificado")
    })
    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(description = "ID del cliente cuyas compras se desean obtener", example = "client123")
            @PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId)
                .map(clients -> new ResponseEntity<>(clients, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Registrar una nueva compra", description = "Guarda una nueva compra en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Compra guardada exitosamente")
    })
    @PostMapping("/save")
    public ResponseEntity<Purchase> save(
            @Parameter(description = "Objeto de compra a guardar", required = true)
            @RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
