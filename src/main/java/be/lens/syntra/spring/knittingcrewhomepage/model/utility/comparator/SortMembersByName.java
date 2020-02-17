package be.lens.syntra.spring.knittingcrewhomepage.model.utility.comparator;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class SortMembersByName implements Comparator<Member> {
    @Override
    public int compare(Member member, Member t1) {
        return member.getFamilyName().toLowerCase().compareTo(t1.getFamilyName().toLowerCase());
    }
}
