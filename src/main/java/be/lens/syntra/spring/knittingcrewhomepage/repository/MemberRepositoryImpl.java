package be.lens.syntra.spring.knittingcrewhomepage.repository;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private List<Member> members;

    public MemberRepositoryImpl() {
        members = new ArrayList<>();
    }

    @Override
    public Collection<Member> getAllMembers() {
        return members;
    }

    @Override
    public Optional<Member> getMember(int id) {
        return members.stream().filter(m -> m.getId() == id).findFirst();
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
    }
}
