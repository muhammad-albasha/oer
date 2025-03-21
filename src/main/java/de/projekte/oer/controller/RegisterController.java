package de.projekte.oer.controller;

import de.projekte.oer.entity.Member;
import de.projekte.oer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    // inject MemberService

    @Autowired
    private MemberService memberService;

    // add Get mapping for /register

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member", new Member());
        return "auth/register";
    }

    // add Post mapping for /processRegistration

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("member") Member member) {
        memberService.registerMember(member);
        return "redirect:auth/login?registerSuccess";
    }
}
