package com.naja.client2.controllers;

import com.naja.client2.ClientService;
import com.naja.client2.entities.Client;
import com.naja.client2.entities.Voiture;
import com.naja.client2.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoitureController {
    @Autowired
    private VoitureRepository voitureRepository;
    private ClientService clientService;
    @GetMapping("/voitures")
    public List findAll(){
        return voitureRepository.findAll();
    }

    @GetMapping("/voitures/{id}")
    public Voiture findById(@PathVariable Long id) throws Exception{
        return voitureRepository.findById(id).orElseThrow(()->new Exception("Client not found"));
    }

    @PostMapping("/voitures/{clientId}")
    public ResponseEntity<Object> save(@PathVariable Long clientId, @RequestBody Voiture voiture) {
        try {
            // Fetch the client details using the clientService
            Client client = clientService.clientById(clientId);
            System.out.println(
                    "Client details: " + client.getId() + " " + client.getNom() + " " + client.getPrenom()
            );

            if (client != null) {
                // Set the fetched client in the voiture object
                voiture.setClient(client);

                // Save the Voiture with the associated Client
                Voiture savedVoiture = voitureRepository.save(voiture);

                return ResponseEntity.ok(savedVoiture);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving voiture: " + e.getMessage());
        }
    }


    @DeleteMapping("/voitures/{id}")
    public void delete(@PathVariable Long id){
        voitureRepository.deleteById(id);
    }

}
