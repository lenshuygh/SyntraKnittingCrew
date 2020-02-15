package be.lens.syntra.spring.knittingcrewhomepage.service;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import be.lens.syntra.spring.knittingcrewhomepage.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void addMember(Member member) {
        memberRepository.addMember(member);
    }

    @Override
    public Collection<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    @Override
    public Member getMemberById(int id) {
        Optional<Member> memberOptional = memberRepository.getMember(id);
        if (memberOptional.isEmpty()) {
            //todo throw err
        }
        return memberOptional.get();
    }

    @Override
    public void updateMember(Member updatedMember) {
        Member memberToUpdate = memberRepository.getMember(updatedMember.getId()).get();
        memberRepository.removeMember(memberToUpdate);
        memberRepository.addMember(updatedMember);
    }
}
