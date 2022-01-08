package com.FastTravel.FastTravelService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.repository.ClientRepository;


@Service
public class ClientService{
    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public List<Client> saveClients(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public String deleteClient(Long id) {
        clientRepository.deleteById(id);
        return "client removed !! " + id;
    }

    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    /* Ainda n acabei
    public Client updateClient(Client client) {
        Client existingClient = clientRepository.findById(client.getId()).orElse(null);
        return clientRepository.save(existingClient);
    }*/
}