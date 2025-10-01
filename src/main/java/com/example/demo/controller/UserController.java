package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*; // allows for the annotations needed by spring

import java.util.ArrayList;


@RestController // tells spring what it is, handles http requests and sends json in response
@RequestMapping("/users") // tells spring that the base path for everything here starts with /users (ex. GET /users returns all users)
public class UserController {
    private ArrayList<User> database = new ArrayList<>(); // "database" since i cant use sqlite

    @GetMapping // tells spring how to handle GET requests
    public ArrayList<User> getAllUsers(){
        return database;
    }

    @PostMapping // Tells spring how to handle POST requests
    public String addUser(@RequestBody User user){ // @requestbody specifies it's from the user request
        database.add(user);
        return "Added: "+ user.getName();
    }


}
