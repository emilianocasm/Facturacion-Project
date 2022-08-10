package com.coderhouse.facturacion.controller;
import com.coderhouse.facturacion.entity.Client;
import com.coderhouse.facturacion.model.ClientSearch;
import com.coderhouse.facturacion.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    /**
     * The createSale method will create a sale, and return a voucher with details.
     */

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClient();
    }

    @GetMapping("{id}")
    public Client getClientByID(@PathVariable Integer id){
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client clientRequest){
        return clientService.createClient(clientRequest);
    }

    @PutMapping("{id}")
    public Client updateClient(@PathVariable Integer id ,@RequestBody Client clientRequest){
        return clientService.updateClient(id, clientRequest);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Integer id){
        clientService.deleteClient(id);
    }
}
