package com.biddingplatform.logic.controllers;

import com.biddingplatform.db.entities.ClientEntity;
import com.biddingplatform.db.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    @Autowired
    private ClientRepository rep;

    @GetMapping("/client")
    public ClientEntity clientGetAll(){

        var list = rep.findAll();

        var client = list.stream().findFirst().get();

        return client;
    }

    @PostMapping("/clientPost")
    public String clientPost(){

        return "result";
    }