package de.projekte.oer.service;

import de.projekte.oer.dao.MemberRepository;
import de.projekte.oer.dao.RoleRepository;
import de.projekte.oer.entity.Member;
import de.projekte.oer.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void registerMember(Member member) {
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
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(String userId) {
        Optional<Member> result = memberRepository.findById(userId);
        Member member = null;
        if (result.isPresent()) {
            member = result.get();
        } else {
            throw new RuntimeException("Did not find member id - " + userId);
        }
        return member;
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteById(String userId) {
        memberRepository.deleteById(userId);

    }
}
