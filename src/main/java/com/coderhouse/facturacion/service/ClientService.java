package com.coderhouse.facturacion.service;

import com.coderhouse.facturacion.entity.Client;
import com.coderhouse.facturacion.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    IClientRepository iClientRepository;

    public List<Client> getClient(){
        return iClientRepository.findAll();
    }

    public Client getClientById(Integer clientId){
        Client client = iClientRepository.findById(clientId).orElse(null);
        if (client == null){
            throw new RuntimeException("El cliente no existe");
        }
        return client;
    }

    public Client createClient(Client client){
        return iClientRepository.save(client);
    }

    public Client updateClient(Integer id, Client client) {
        Client searchClient = iClientRepository.findById(id)
                .orElse(null);
        if (searchClient == null){
            throw new RuntimeException("El cliente no existe");
        }
        searchClient.setDni(client.getDni());
        searchClient.setEmail(client.getEmail());
        searchClient.setName(client.getName());
        searchClient.setSurname(client.getSurname());
        return iClientRepository.save(searchClient);
    }

    public void deleteClient(Integer id) {
        Client searchClient = iClientRepository.findById(id)
                .orElse(null);
        if (searchClient == null){
            throw new RuntimeException("El cliente no existe");
        }
        iClientRepository.deleteById(id);
    }
}
