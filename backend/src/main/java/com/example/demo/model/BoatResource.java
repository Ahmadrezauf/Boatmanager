package com.example.demo.resource;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Boat;
import com.example.demo.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BoatResource {

    @Autowired
    private BoatService boatService;

    @GetMapping("/boats")
    public List<Boat> getAllBoats() {
        return boatService.getAllBoats();
    }

    @GetMapping("/boats/{id}")
    public Boat getBoatById(@PathVariable(value = "id") Long boatId) throws ResourceNotFoundException {
        return boatService.getBoatById(boatId);
    }

    @PostMapping("/boats")
    public Boat createBoat(@Valid @RequestBody Boat boat) {
        return boatService.createBoat(boat);
    }

    @PutMapping("/boats/{id}")
    public Boat updateBoat(@PathVariable(value = "id") Long boatId,
                           @Valid @RequestBody Boat boatDetails) throws ResourceNotFoundException {
        return boatService.updateBoat(boatId, boatDetails);
    }

    @DeleteMapping("/boats/{id}")
    public void deleteBoat(@PathVariable(value = "id") Long boatId) throws ResourceNotFoundException {
        boatService.deleteBoat(boatId);
    }
}
