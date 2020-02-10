package be.lens.syntra.spring.knittingcrewhomepage.repository;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;

import java.util.Collection;
import java.util.Optional;

public interface MemberRepository {
    Collection<Member> getAllMembers();

    Optional<Member> getMember(int id);

    void addMember(Member member);
}
