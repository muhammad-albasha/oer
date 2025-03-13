package de.projekte.oer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/systems")
public class SystemsController {

    @GetMapping("/")
    public String systems() {

        return "systems";
    }
}
