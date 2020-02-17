package be.lens.syntra.spring.knittingcrewhomepage.model.utility.comparator;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;

import java.util.Comparator;

public class SortMembersByName implements Comparator<Member> {
    @Override
    public int compare(Member member, Member t1) {
        return member.getFamilyName().toLowerCase().compareTo(t1.getFamilyName().toLowerCase());
    }
}
