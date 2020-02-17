package be.lens.syntra.spring.knittingcrewhomepage.model.utility.comparator;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;

import java.util.Comparator;

public class SortMembersById implements Comparator<Member> {
    @Override
    public int compare(Member member, Member t1) {
        return member.getId() - t1.getId();
    }
}
