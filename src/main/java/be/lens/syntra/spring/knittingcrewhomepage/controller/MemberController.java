package be.lens.syntra.spring.knittingcrewhomepage.controller;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
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
import java.util.Comparator;
import java.util.Date;

@Controller
@RequestMapping("/knittingcrew")
public class MemberController {
    private static final int NO_ID_PRESENT = -1;
    @Autowired
    MemberService memberService;

    @Autowired
    Comparator memberComparator;

    @GetMapping
    public String displayOverView(Model model) {
        model.addAttribute("members",memberService.getAllMembers());
        model.addAttribute("sorter",memberComparator);
        return "overview";
    }

    @GetMapping("/memberDetail/{id}")
    public ModelAndView displayDetail(@PathVariable String id) {
        return new ModelAndView("detail", "member", memberService.getMemberById(Integer.parseInt(id)));
    }

    @GetMapping("/editMember/{id}")
    public ModelAndView displayEditingMember(@PathVariable String id) {
        return new ModelAndView("edit", "member", memberService.getMemberById(Integer.parseInt(id)));
    }

    @PostMapping("/editMember/*")
    public String saveUpdatedMember(@ModelAttribute("member") Member member) {
        memberService.updateMember(member);
        return "redirect:/knittingcrew";
    }


    @GetMapping("/addMember")
    public ModelAndView provideEmptyFormPage(){
        Member member = new Member();
        member.setId(NO_ID_PRESENT);
        return new ModelAndView("edit","member",member);
    }

    @PostMapping("/addMember")
    public String saveNewMember(@ModelAttribute("member") Member member){
        memberService.addMember(member);
        return "redirect:/knittingcrew";
    }

    // formatting the date string as a LocalDate to the specification from the annotated date field in the member model
    // other fields that could be formatted need to be excluded
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
