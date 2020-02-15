package be.lens.syntra.spring.knittingcrewhomepage.service;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;

import java.util.Collection;

public interface MemberService {
    void addMember(Member member);

    Collection<Member> getAllMembers();

    Member getMemberById(int id);

    void updateMember(Member member);
}
