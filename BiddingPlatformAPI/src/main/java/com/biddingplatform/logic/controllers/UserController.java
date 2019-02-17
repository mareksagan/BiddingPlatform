package com.biddingplatform.logic.controllers;

import com.biddingplatform.db.entities.ClientEntity;
import com.biddingplatform.db.services.ClientService;
import com.biddingplatform.logic.DTOs.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RequestMapping("client")
@RestController
public class UserController {

    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public ClientEntity getById(@PathVariable UUID id){
        return service.findById(id);
    }

    @GetMapping("/email/{email}")
    public ClientEntity getByEmail(@PathVariable String email){
        return service.findByEmail(email);
    }

    @GetMapping("/name/{firstname}/{lastname}")
    public ArrayList<ClientEntity> getByEmail(@PathVariable String firstname, @PathVariable String lastname){
        return service.findByName(firstname, lastname);
    }

    @GetMapping("/all")
    public ArrayList<ClientEntity> getAll(){
        return service.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ClientDTO client){

        var newClient = new ClientEntity();

        if (client != null) {
            newClient.setFirstName(client.firstName);
            newClient.setLastName(client.lastName);
            newClient.setEmail(client.email);
            newClient.setTaxId(client.taxId);

            service.add(newClient);

            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable UUID id){

        service.delete(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/count")
    public long count(){
        return service.count();
    }
}
