package com.biddingplatform.controllers;

import com.biddingplatform.db.repositories.UserRepository;
import com.biddingplatform.logic.controllers.UserController;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class UserControllerTest {
    @Mock
    UserRepository rep;
    @InjectMocks
    UserController userController;

    /*@BeforeEach
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
    }*/
}
