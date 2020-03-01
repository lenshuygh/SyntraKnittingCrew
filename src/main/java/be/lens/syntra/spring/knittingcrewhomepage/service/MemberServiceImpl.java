package be.lens.syntra.spring.knittingcrewhomepage.service;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import be.lens.syntra.spring.knittingcrewhomepage.repository.MemberRepository;
import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberAlreadyPresentException;
import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void addMember(Member member) throws MemberAlreadyPresentException {
        if (memberRepository.getMemberByFullName(member.getName(), member.getFamilyName()).isPresent()) {
            throw new MemberAlreadyPresentException(member);
        }
        memberRepository.addMember(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers().stream()
                .sorted(Comparator.comparing(Member::getFamilyName))
                .sorted(Comparator.comparing(Member::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Member getMemberById(int id) throws MemberNotPresentException {
        Optional<Member> memberOptional = memberRepository.getMember(id);
        if (memberOptional.isEmpty()) {
            throw new MemberNotPresentException(id);
        }
        return memberOptional.get();
    }

    @Override
    public void updateMember(Member updatedMember) throws MemberAlreadyPresentException,MemberNotPresentException {
        Member memberToUpdate;
        Optional<Member> memberOptional = memberRepository.getMember(updatedMember.getId());
        if(memberOptional.isPresent()){
            memberToUpdate = memberOptional.get();
        }else{
            throw new MemberNotPresentException(updatedMember.getId());
        }
        if (memberRepository.getMemberByFullName(updatedMember.getName(), updatedMember.getFamilyName()).isPresent()) {
            throw new MemberAlreadyPresentException(updatedMember);
        }
        memberRepository.removeMember(memberToUpdate);
        memberRepository.addMember(updatedMember);
    }
}
