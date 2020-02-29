package be.lens.syntra.spring.knittingcrewhomepage.service;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import be.lens.syntra.spring.knittingcrewhomepage.repository.MemberRepository;
import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberAlreadyPresentException;
import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void addMember(Member member) throws MemberAlreadyPresentException {
        if(memberRepository.getMemberByFullName(member.getName(),member.getFamilyName()).isPresent()){
            throw new MemberAlreadyPresentException(member);
        }
        memberRepository.addMember(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    @Override
    public Member getMemberById(int id) throws MemberNotPresentException {
        Optional<Member> memberOptional = memberRepository.getMember(id);
        if (memberOptional.isPresent()) {
            throw new MemberNotPresentException(id);
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
