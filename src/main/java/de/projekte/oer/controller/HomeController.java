package de.projekte.oer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // add Get mapping for /

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

}









