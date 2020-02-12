package be.lens.syntra.spring.knittingcrewhomepage.repository;

import be.lens.syntra.spring.knittingcrewhomepage.model.KnittingCrewRole;
import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import be.lens.syntra.spring.knittingcrewhomepage.model.Stitches;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private List<Member> members;

    public MemberRepositoryImpl() {
        List<Stitches> stitches = new ArrayList<>();
        stitches.add(Stitches.CABLE);
        stitches.add(Stitches.BEGINNER_LACE);
        members = new ArrayList<>();
        Member member1 = Member.builder().name("Lens").familyName("Huygh").id(1).email("lens.huygh@gmail.com").knownStitches(stitches).knittingCrewRole(KnittingCrewRole.MEMBER).build();
        Member member2 = Member.builder().name("Lens").familyName("Huygh").id(2).email("lens.huygh@gmail.com").knownStitches(stitches).knittingCrewRole(KnittingCrewRole.PRESIDENT).build();
        Member member3 = Member.builder().name("Lens").familyName("Huygh").id(3).email("lens.huygh@gmail.com").knownStitches(stitches).knittingCrewRole(KnittingCrewRole.VICE_PRESIDENT).build();
        members.add(member1);
        members.add(member2);
        members.add(member3);
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
