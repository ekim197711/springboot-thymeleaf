package com.codeinvestigator.springbootthymeleaf.spaceships;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpaceShipRepository extends CrudRepository<SpaceShip, Integer> {
    public List<SpaceShip> findAll();
}
