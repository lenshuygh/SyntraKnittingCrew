package be.lens.syntra.spring.knittingcrewhomepage.controller;

import be.lens.syntra.spring.knittingcrewhomepage.model.KnittingCrewRole;
import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import be.lens.syntra.spring.knittingcrewhomepage.model.Stitches;
import be.lens.syntra.spring.knittingcrewhomepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/knittingcrew")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping
    public ModelAndView displayOverView() {
        return new ModelAndView("overview", "members", memberService.getAllMembers());
    }

    @GetMapping("/memberDetail/{id}")
    public ModelAndView displayDetail(@PathVariable String id){
        //memberService.getMemberById(Integer.parseInt(id));
        return new ModelAndView("detail", "member",memberService.getMemberById(Integer.parseInt(id)));
    }

    @GetMapping("/editMember{id}")
    public ModelAndView displayEditingMember(@PathVariable String id){
        //memberService.getMemberById(Integer.parseInt(id));
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("member",memberService.getMemberById(Integer.parseInt(id)));
        modelMap.put("roles", KnittingCrewRole.values());
        modelMap.put("stitches", Stitches.values());
        return new ModelAndView("edit", "modelMap",modelMap);
    }

    @GetMapping("/editTest")
    public ModelAndView editTest(Model model){
        return new ModelAndView("edittest","member",memberService.getMemberById(3));
    }
}
