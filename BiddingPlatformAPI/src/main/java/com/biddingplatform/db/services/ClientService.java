package com.biddingplatform.db.services;

import com.biddingplatform.db.entities.ClientEntity;
import com.biddingplatform.db.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ArrayList<ClientEntity> findByName(String firstName, String lastName){
        return repository.findByFirstNameOrLastName(firstName, lastName);
    }

    public ArrayList<ClientEntity> findAll(){
        return repository.findAll();
    }

    public ClientEntity findById(UUID id){
        return repository.findById(id).get();
    }

    public ClientEntity findByEmail(String email){
        return repository.findByEmail(email);
    }

    public long count(){
        return repository.count();
    }

    public void add(ClientEntity newClient){ repository.save(newClient); }

    public void delete(UUID id) { repository.deleteById(id); }
}
