package com.biddingplatform.logic.controllers;

import com.biddingplatform.db.entities.ClientEntity;
import com.biddingplatform.db.repositories.ClientRepository;
import com.biddingplatform.logic.DTOs.ClientDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.Mockito.*;

class UserControllerTest {
    @Mock
    ClientRepository rep;
    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testClientGetById() {
        when(rep.findAll()).thenReturn(new ArrayList<>());

        ClientEntity result = userController.getById(UUID.fromString("2872fbb6-0391-479b-b84d-2f09efa31f43"));
        Assertions.assertEquals(new ClientEntity(), result);
    }

    @Test
    void testClientPost() {
        ResponseEntity result = userController.add(new ClientDTO());
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @org.junit.jupiter.api.Test
    void clientGetAll() {
    }

    @org.junit.jupiter.api.Test
    void clientPost() {
    }
}
