package be.lens.syntra.spring.knittingcrewhomepage.config;

import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberAlreadyPresentException;
import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberNotPresentException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(MemberAlreadyPresentException.class)
    public ModelAndView handleAlreadyPresentException(MemberAlreadyPresentException e) {
        return new ModelAndView("error", "localizedMessage", e.getLocalizedMessage());
    }

    @ExceptionHandler(MemberNotPresentException.class)
    public ModelAndView memberNotPresentException(MemberNotPresentException e) {
        return new ModelAndView("error", "localizedMessage", e.getLocalizedMessage());
    }
}

