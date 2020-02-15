package be.lens.syntra.spring.knittingcrewhomepage.controller;

import be.lens.syntra.spring.knittingcrewhomepage.model.KnittingCrewRole;
import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import be.lens.syntra.spring.knittingcrewhomepage.model.Stitches;
import be.lens.syntra.spring.knittingcrewhomepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public ModelAndView editTest(){
        return new ModelAndView("edittest","member",memberService.getMemberById(3));
    }

    @PostMapping("/editTest")
    public String saveMember(@ModelAttribute("member") Member member){
        memberService.updateMember(member);
        return "redirect:/knittingcrew/memberDetail/"+member.getId();
    }

    // formatting the date string as a LocalDate to the specification from the annotated date field in the member model
    // we need to exclude other fields that could be formatted
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("member.id");

        dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("dd-MM-yyyy").parse(value));
                } catch (ParseException e) {
                    setValue(null);
                }
            }
        });

    }
}
