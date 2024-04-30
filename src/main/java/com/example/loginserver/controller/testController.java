package com.example.loginserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping
    public String testGet(@RequestParam("id")String id){
        return "id is " + id;
    }
}
