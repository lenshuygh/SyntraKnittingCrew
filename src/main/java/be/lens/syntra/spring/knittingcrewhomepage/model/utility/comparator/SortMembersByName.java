package be.lens.syntra.spring.knittingcrewhomepage.model.utility.comparator;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class SortMembersByName implements Comparator<Member> {
    @Override
    public int compare(Member member, Member t1) {
        if (member.getFamilyName().equals(t1.getFamilyName())) {
            return member.getName().toLowerCase().compareTo(t1.getName().toLowerCase());
        } else {
            return member.getFamilyName().toLowerCase().compareTo(t1.getFamilyName().toLowerCase());
        }
    }
}
