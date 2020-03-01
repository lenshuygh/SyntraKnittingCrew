package be.lens.syntra.spring.knittingcrewhomepage.service;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberAlreadyPresentException;
import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberNotPresentException;

import java.util.List;

public interface MemberService {
    void addMember(Member member) throws MemberAlreadyPresentException;

    List<Member> getAllMembers();

    Member getMemberById(int id) throws MemberNotPresentException;

    void updateMember(Member member) throws MemberAlreadyPresentException,MemberNotPresentException;
}
