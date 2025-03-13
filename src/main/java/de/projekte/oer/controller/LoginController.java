package de.projekte.oer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    //todo: add request mapping for /login

    @GetMapping("/login")
    public String login() {

        return "auth/login";
    }

    //todo: add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String accessDenied() {

        return "errors/access-denied";
    }

}










