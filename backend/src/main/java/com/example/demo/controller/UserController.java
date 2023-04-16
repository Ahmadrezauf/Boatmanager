package com.example.demo.controller;

import com.example.demo.model.Boat;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        users.add(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
        for (User u : users) {
            if (u.getId() == id) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                break;
            }
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @PostMapping("/boats")
    public void addBoat(@RequestBody Boat boat) {
        // implementation to add boat to a user's list of boats
    }

    @GetMapping("/users/{id}/boats")
    public List<Boat> getBoatsByUserId(@PathVariable("id") int id) {
        // implementation to get a user's list of boats
        return null;
    }
}
