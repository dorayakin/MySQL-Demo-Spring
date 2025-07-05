package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {
    
    @GetMapping("/")
    public String tempHome(){
        return "index";
    }
}
