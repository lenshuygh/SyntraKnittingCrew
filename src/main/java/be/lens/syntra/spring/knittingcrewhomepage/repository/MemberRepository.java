package be.lens.syntra.spring.knittingcrewhomepage.repository;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> getMemberByFullName(String name, String familyName);

    List<Member> getAllMembers();

    Optional<Member> getMember(int id);

    void addMember(Member member);

    void removeMember(Member member);
}
