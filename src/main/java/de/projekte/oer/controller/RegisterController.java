package de.projekte.oer.controller;

import de.projekte.oer.dao.MemberRepository;
import de.projekte.oer.dao.RoleRepository;
import de.projekte.oer.entity.Member;
import de.projekte.oer.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Verwendung des delegierenden Encoders

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member", new Member());
        return "register"; // verweist auf register.html
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("member") Member member) {
        // Passwort verschlüsseln – das Ergebnis enthält automatisch das "{bcrypt}"-Präfix
        member.setPw(passwordEncoder.encode(member.getPw()));
        // Aktiven Status setzen (true entspricht in der DB 1)
        member.setActive(true);
        memberRepository.save(member);

        // Standardrolle zuweisen: ROLE_EMPLOYEE
        Role role = new Role();
        role.setUserId(member.getUserId());
        role.setRole("ROLE_EMPLOYEE");
        roleRepository.save(role);

        // Weiterleitung zur Loginseite, ggf. mit Erfolgsmeldung
        return "redirect:/login?registerSuccess";
    }
}
