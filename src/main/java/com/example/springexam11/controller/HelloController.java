package com.example.springexam11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello() throws IOException {
        return "hello";
    }
}
