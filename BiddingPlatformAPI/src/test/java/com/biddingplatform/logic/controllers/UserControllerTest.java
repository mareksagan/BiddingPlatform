package com.biddingplatform.logic.controllers;

import com.biddingplatform.db.entities.ClientEntity;
import com.biddingplatform.db.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

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
    void testClientGetAll() {
        when(rep.findAll()).thenReturn(Arrays.<ClientEntity>asList(new ClientEntity()));

        ClientEntity result = userController.clientGetAll();
        Assertions.assertEquals(new ClientEntity(), result);
    }

    @Test
    void testClientPost() {
        String result = userController.clientPost();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @org.junit.jupiter.api.Test
    void clientGetAll() {
    }

    @org.junit.jupiter.api.Test
    void clientPost() {
    }
}
