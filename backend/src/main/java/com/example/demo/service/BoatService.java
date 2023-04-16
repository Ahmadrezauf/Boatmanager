package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Boat;

import java.util.List;

public interface BoatService {
    List<Boat> getAllBoats();
    Boat getBoatById(Long boatId) throws ResourceNotFoundException;
    Boat createBoat(Boat boat);
    Boat updateBoat(Long boatId, Boat boatDetails) throws ResourceNotFoundException;
    void deleteBoat(Long boatId) throws ResourceNotFoundException;
}
