package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Boat;

public interface BoatRepository {

    List<Boat> findAll();

    Boat findById(Long id);

    void save(Boat boat);

    void deleteById(Long id);
}
