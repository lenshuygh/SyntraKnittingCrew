package be.lens.syntra.spring.knittingcrewhomepage.service.exception;

public class MemberNotPresentException extends Throwable {
    public MemberNotPresentException(int id) {
        super("A member with id: '" + id + "' is not present in the system.");
    }
}
