package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Boat;
import com.example.demo.repository.BoatRepository;

@Service
public class BoatServiceImpl implements BoatService {

    @Autowired
    private BoatRepository boatRepository;

    @Override
    public List<Boat> getAllBoats() {
        return boatRepository.findAll();
    }

    @Override
    public Optional<Boat> getBoatById(Long id) {
        return boatRepository.findById(id);
    }

    @Override
    public Boat saveBoat(Boat boat) {
        return boatRepository.save(boat);
    }

    @Override
    public void deleteBoatById(Long id) {
        boatRepository.deleteById(id);
    }
}
