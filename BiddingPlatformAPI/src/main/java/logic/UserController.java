package logic;

import db.DoctorEntity;
import db.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private DoctorRepository rep;

    @GetMapping("/beniz")
    public String penisGetAll(Model model){

        List<DoctorEntity> list = rep.findAll();

        model.addAttribute("docs", list);

        return "demo";
    }

    @PostMapping("/benizPost")
    public String penisPost(@ModelAttribute("doctor") DoctorEntity doc){

        rep.save(doc);

        return "result";
    }
}
