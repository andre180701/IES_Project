package com.FastTravel.FastTravelService.controller;


import java.util.List;

import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PostMapping("/addClients")
    public List<Client> addClients(@RequestBody List<Client> clients) {
        return clientService.saveClients(clients);
    }

    @GetMapping("/clients")
    public List<Client> findAllClients() {
        return clientService.getClients();
    }

    @GetMapping("/clientById/{id}")
    public Client findClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    
    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }
}
