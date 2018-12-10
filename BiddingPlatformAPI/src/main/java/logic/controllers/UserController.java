package logic.controllers;

import db.entities.ClientEntity;
import db.repositories.ClientRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private ClientRepository rep;

    @GetMapping("/client")
    public String clientGetAll(Model model){

        List<ClientEntity> list = rep.findAll();

        model.addAttribute("docs", list);

        return "demo";
    }

    @PostMapping("/clientPost")
    public String clientPost(@ModelAttribute("client") ClientEntity doc){

        rep.save(doc);

        return "result";
    }
}
