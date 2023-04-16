package com.example.demo.controller;

import com.example.demo.model.Boat;
import com.example.demo.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boats")
public class BoatController {

    @Autowired
    private BoatService boatService;

    @GetMapping("/")
    public ResponseEntity<List<Boat>> getAllBoats() {
        List<Boat> boats = boatService.getAllBoats();
        return ResponseEntity.ok(boats);
    }

    @PostMapping("/")
    public ResponseEntity<Boat> addBoat(@RequestBody Boat boat) {
        Boat newBoat = boatService.addBoat(boat);
        return ResponseEntity.ok(newBoat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boat> getBoatById(@PathVariable Long id) {
        Boat boat = boatService.getBoatById(id);
        if (boat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(boat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boat> updateBoat(@PathVariable Long id, @RequestBody Boat boat) {
        Boat updatedBoat = boatService.updateBoat(id, boat);
        if (updatedBoat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBoat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoat(@PathVariable Long id) {
        boolean deleted = boatService.deleteBoat(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
