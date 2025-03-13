package de.projekte.oer.service;

import de.projekte.oer.entity.Member;

import java.util.List;

//todo: Refactor this interface to use the MemberRepository instead of the MemberDao
public interface MemberService {
    void registerMember(Member member);
    List<Member> findAll();
    Member findById(String userId);
    Member save(Member member);
    void deleteById(String userId);
}
