package de.projekte.oer.controller;

import org.springframework.ui.Model;
import de.projekte.oer.entity.Member;
import de.projekte.oer.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/leaders")
public class LeadersController {

    private final MemberService memberService;

    public LeadersController(MemberService theMemberService) {
        memberService = theMemberService;
    }

    @GetMapping("/")
    public String leaders() {

        return "leaders";
    }

    @GetMapping("/list")
    public String listUsers(Model theModel) {

        List<Member> theMembers = memberService.findAll();
        theModel.addAttribute("members", theMembers);
        return "users/users-management";
    }


}
