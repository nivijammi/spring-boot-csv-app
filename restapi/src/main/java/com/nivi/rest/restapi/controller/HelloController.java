package com.nivi.rest.restapi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        return "User " + user.getName() + " created successfully";
    }

    @GetMapping("/users")
    public List<User>getAllUser(){
        List<User> users = new ArrayList<>();
        users.add(new User("Ezel",16));
        users.add(new User("AJ",14));
        return users;
    }

    @GetMapping("/greet/{name}")
    public String greetUser(@PathVariable String name){
        return "Hello, "+name+"!";
    }




}
