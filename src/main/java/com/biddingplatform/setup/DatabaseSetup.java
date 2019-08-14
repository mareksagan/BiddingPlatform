package com.biddingplatform.setup;

import com.biddingplatform.db.entities.User;
import com.biddingplatform.db.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DatabaseSetup implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        userService.add("Marius", "Ungureanu",
                "a@seznam.cz","a", 1, 2,
                "Jindrisska", "Prague", "Czechia", "",
                234325);

    }
}
