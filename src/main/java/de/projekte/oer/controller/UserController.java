package de.projekte.oer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    // add a request mapping for /leaders

    @GetMapping("/leaders")
    public String leaders() {

        return "leaders";
    }

    // add request mapping for /systems

    @GetMapping("/systems")
    public String systems() {

        return "systems";
    }

}









