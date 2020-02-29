package be.lens.syntra.spring.knittingcrewhomepage.service.exception;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;

public class MemberAlreadyPresentException extends Throwable {
    public MemberAlreadyPresentException(Member member) {
        super("A member named '" + member.getName() + ' ' + member.getFamilyName() + "' is already present in our system.");
    }
}
