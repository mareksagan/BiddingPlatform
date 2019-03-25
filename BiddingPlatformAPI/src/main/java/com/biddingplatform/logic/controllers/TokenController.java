package com.biddingplatform.logic.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @PostMapping("/login")
    public String login(){

        return "result";
    }

    @PostMapping("/logout")
    public String logout(){

        return "result";
    }
}
