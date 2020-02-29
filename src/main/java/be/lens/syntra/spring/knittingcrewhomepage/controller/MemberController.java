package be.lens.syntra.spring.knittingcrewhomepage.controller;

import be.lens.syntra.spring.knittingcrewhomepage.model.Member;
import be.lens.syntra.spring.knittingcrewhomepage.service.MemberService;
import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberAlreadyPresentException;
import be.lens.syntra.spring.knittingcrewhomepage.service.exception.MemberNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

@Controller
@RequestMapping("/knittingcrew")
public class MemberController {
    private static final int ID_FOR_NEW_MEMBER = -1;
    public static final String MEMBER_MODEL = "member";
    public static final String REDIRECT_KNITTINGCREW_OVERVIEW = "redirect:/knittingcrew/overview";
    @Autowired
    MemberService memberService;

    @GetMapping("/overview")
    public String displayOverView(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "overview";
    }

    @GetMapping("/memberDetail/{id}")
    public ModelAndView displayDetail(@PathVariable String id) throws MemberNotPresentException {
        return new ModelAndView("detail", MEMBER_MODEL, memberService.getMemberById(Integer.parseInt(id)));
    }

    @GetMapping("/editMember/{id}")
    public ModelAndView displayEditingMember(@PathVariable String id) throws MemberNotPresentException {
        return new ModelAndView("edit", MEMBER_MODEL, memberService.getMemberById(Integer.parseInt(id)));
    }

    @PostMapping("/editMember/*")
    public ModelAndView saveUpdatedMember(@Valid @ModelAttribute("member") Member member, BindingResult br) throws MemberAlreadyPresentException {
        if (br.hasErrors()) {
            return new ModelAndView("edit", MEMBER_MODEL, member);
        }
        memberService.updateMember(member);
        return new ModelAndView(REDIRECT_KNITTINGCREW_OVERVIEW);
    }


    @GetMapping("/addMember")
    public ModelAndView provideEmptyFormPage() {
        Member member = new Member();
        member.setId(ID_FOR_NEW_MEMBER);
        return new ModelAndView("edit", MEMBER_MODEL, member);
    }

    @PostMapping("/addMember")
    public ModelAndView saveNewMember(@Valid @ModelAttribute("member") Member member, BindingResult br) throws MemberAlreadyPresentException{
        if (br.hasErrors()) {
            return new ModelAndView("edit", MEMBER_MODEL, member);
        }
            memberService.addMember(member);
        return new ModelAndView(REDIRECT_KNITTINGCREW_OVERVIEW);
    }

    @GetMapping
    public String displayStartPage() {
        return REDIRECT_KNITTINGCREW_OVERVIEW;
    }

    @GetMapping("/login")
    public String displayLoginForm() {
        return "loginForm";
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
