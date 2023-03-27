package ru.titov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class CustomController {

    @PostMapping("/custom")
    public void customPost() {
        System.out.println();
    }

    @PutMapping("/custom")
    public void customPut() {
        System.out.println();
    }

    @DeleteMapping("/custom")
    public void customDelete() {
        System.out.println();
    }
}
