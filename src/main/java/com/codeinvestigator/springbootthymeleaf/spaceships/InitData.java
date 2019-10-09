package com.codeinvestigator.springbootthymeleaf.spaceships;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitData {

    private final SpaceShipRepository repository;

    public InitData(SpaceShipRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void postConstruct(){
        repository.saveAll(List.of(
                new SpaceShip(null, "Falcon", 10),
                new SpaceShip(null, "Blackbird", 40),
                new SpaceShip(null, "Sourcer", 35),
                new SpaceShip(null, "Hawk", 120),
                new SpaceShip(null, "Eagler", 92)
        ));
    }
}
