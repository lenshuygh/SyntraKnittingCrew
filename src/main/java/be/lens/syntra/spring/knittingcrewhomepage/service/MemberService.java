package be.lens.syntra.spring.knittingcrewhomepage.service;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;

import java.util.Collection;
import java.util.Optional;

public interface MemberService {
    void addMember(Member member);

    Collection<Member> getAllMembers();

    Member getMemberById(int id);
}
