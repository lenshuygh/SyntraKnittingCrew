package be.lens.syntra.spring.knittingcrewhomepage.repository;

import be.lens.syntra.spring.knittingcrewhomepage.model.Address;
import be.lens.syntra.spring.knittingcrewhomepage.model.KnittingCrewRole;
import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import be.lens.syntra.spring.knittingcrewhomepage.model.Stitches;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private static final int ID_FOR_NEW_MEMBER = -1;
    private List<Member> members;

    public MemberRepositoryImpl() {
        List<Stitches> stitches = new ArrayList<>();
        stitches.add(Stitches.CABLE);
        stitches.add(Stitches.BEGINNER_LACE);
        List<Stitches> stitches2 = new ArrayList<>(stitches);
        stitches2.add(Stitches.RIB);
        members = new ArrayList<>();
        Address address = Address.builder().city("Diepenbeek").houseNumber("85").poBox("/").street("Ganzestreet").zipCode("3590").build();
        Member member1 = Member.builder().name("Lens").familyName("Huygh").id(createId()).email("lens.huygh@gmail.com").knownStitches(stitches).knittingCrewRole(KnittingCrewRole.MEMBER).address(address).phone("0498/21.26.22").birthDate(LocalDate.of(1980, 06, 23)).build();
        members.add(member1);
        Member member2 = Member.builder().name("Lens").familyName("Huygh").id(createId()).email("lens.huygh@gmail.com").knownStitches(stitches).knittingCrewRole(KnittingCrewRole.PRESIDENT).address(address).build();
        members.add(member2);
        Member member3 = Member.builder().name("Lens").familyName("Huygh").id(createId()).email("lens.huygh@gmail.com").knownStitches(stitches2).knittingCrewRole(KnittingCrewRole.VICE_PRESIDENT).address(address).build();
        members.add(member3);
    }

    @Override
    public List<Member> getAllMembers() {
        return members;
    }

    @Override
    public Optional<Member> getMember(int id) {
        return members.stream().filter(m -> m.getId() == id).findFirst();
    }

    @Override
    public void addMember(Member member) {
        if(member.getId() == ID_FOR_NEW_MEMBER) {
            member.setId(createId());
        }
        members.add(member);
    }

    @Override
    public void removeMember(Member member) {
        members.remove(member);
    }

    private int createId() {
        OptionalInt max = members.stream().mapToInt(Member::getId).max();
        return max.isEmpty() ? 1 : max.getAsInt() + 1;
    }
}
