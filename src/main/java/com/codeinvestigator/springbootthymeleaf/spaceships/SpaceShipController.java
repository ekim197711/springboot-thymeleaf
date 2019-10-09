package com.codeinvestigator.springbootthymeleaf.spaceships;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/spaceship")
public class SpaceShipController {

    private final SpaceShipRepository repository;

    public SpaceShipController(SpaceShipRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String spaceships(Model model) {
        List<SpaceShip> all = repository.findAll();
        if (all.size() > 0)
            model.addAttribute("spaceships", all);
        return "spaceshipoverview";
    }

    @GetMapping("/new")
    public String newSpaceshipForm(Model model){
        model.addAttribute("spaceship", new SpaceShip());
        return "newspaceshipform";
    }

    @PostMapping("/create")
    public String createSpaceshipInDatabase(SpaceShip spaceship, BindingResult bindingResult, Model model){
        repository.save(spaceship);
        return spaceships(model);
    }

    @GetMapping("/delete/{id}")
    public String deleteSpaceship(@PathVariable("id") Integer id,
                                  Model model){
        repository.deleteById(id);
        return spaceships(model);
    }
}
