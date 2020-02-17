package be.lens.syntra.spring.knittingcrewhomepage.model.utility.comparator;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;

import java.util.Comparator;

public class SortMembersByRole implements Comparator<Member> {
    @Override
    public int compare(Member member, Member t1) {
        return member.getKnittingCrewRole().getRoleName().compareTo(t1.getKnittingCrewRole().toString());
    }
}
