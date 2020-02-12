package be.lens.syntra.spring.knittingcrewhomepage.controller;

import be.lens.syntra.spring.knittingcrewhomepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/knittingcrew")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping
    public ModelAndView displayOverView() {
        return new ModelAndView("overview", "members", memberService.getAllMembers());
    }
}
