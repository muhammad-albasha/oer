package de.projekte.oer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // add Get mapping for /

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    // add a Get mapping for /leaders

    @GetMapping("/leaders")
    public String leaders() {

        return "leaders";
    }

    // add Get mapping for /systems

    @GetMapping("/systems")
    public String systems() {

        return "systems";
    }

}









