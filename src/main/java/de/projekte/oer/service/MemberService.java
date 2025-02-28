package de.projekte.oer.service;

import de.projekte.oer.entity.Member;

//todo: Refactor this interface to use the MemberRepository instead of the MemberDao
public interface MemberService {
    void registerMember(Member member);
}
