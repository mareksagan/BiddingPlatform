package com.biddingplatform.logic.controllers;

import com.biddingplatform.db.entities.UserEntity;
import com.biddingplatform.db.services.UserService;
import com.biddingplatform.logic.DTOs.UserDTO;
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
    private UserService userService;

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable UUID id){
        return userService.findById(id);
    }

    @GetMapping("/email/{email}")
    public UserEntity getByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @GetMapping("/name/{firstname}/{lastname}")
    public ArrayList<UserEntity> getByEmail(@PathVariable String firstname, @PathVariable String lastname){
        return userService.findByName(firstname, lastname);
    }

    @GetMapping("/all")
    public ArrayList<UserEntity> getAll(){
        return userService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody UserDTO user){

        if (user != null) {
            userService.add(user.firstName, user.lastName, user.email, user.password,
                    user.apartment, user.building, user.street, user.city,
                    user.country, user.companyName, user.taxId);

            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable UUID id){

        userService.delete(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/count")
    public long count(){
        return userService.count();
    }
}
