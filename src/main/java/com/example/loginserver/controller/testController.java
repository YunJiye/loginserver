package com.example.loginserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="/test")
public class testController {

    // get method test
    @ResponseBody
    @GetMapping("/get")
    public String testGet(@RequestParam("id")String id){
        return "id is " + id;
    }

    // thymeleaf calling test
    @GetMapping("/thymeleaf")
    public String testThymeleaf(){
        return "testThymeleaf";
    }
}