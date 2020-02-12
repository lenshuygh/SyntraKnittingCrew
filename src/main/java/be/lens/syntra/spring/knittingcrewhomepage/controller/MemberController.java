package be.lens.syntra.spring.knittingcrewhomepage.controller;

import be.lens.syntra.spring.knittingcrewhomepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/memberDetail{id}")
    public ModelAndView displayDetail(@PathVariable String id){
        memberService.getMemberById(Integer.parseInt(id));
        return new ModelAndView("detail", "member",memberService.getMemberById(Integer.parseInt(id)));
    }

    @GetMapping("/editMember{id}")
    public ModelAndView displayEditingMember(@PathVariable String id){
        memberService.getMemberById(Integer.parseInt(id));
        return new ModelAndView("edit", "member",memberService.getMemberById(Integer.parseInt(id)));
    }
}
