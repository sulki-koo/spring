package jdbcboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jdbcboard.model.Member;
import jdbcboard.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
   
   @Autowired
   MemberService memberService;
   
   @GetMapping("/members")
   public ModelAndView selectMember() {
      ModelAndView mav = new ModelAndView();
      mav.addObject("memberList", memberService.selectMember());
      mav.setViewName("/member/listMember");
      return mav;
   }
   
   @GetMapping("/members/{mid}")
   public ModelAndView getMember(@PathVariable String mid) {
      ModelAndView mav = new ModelAndView();
      mav.addObject("member", memberService.getMember(mid));
      mav.setViewName("/member/getMember");
      return mav;
   }
   
   @GetMapping("/insertMemberForm")
   public String insertMemberForm() {
      return "/member/insertMemberForm";
   }
   
   @PostMapping("/members")
   public String insertMember(@ModelAttribute Member member) {
      memberService.insertMember(member);
      return "redirect:/member/members";
   }
   
   @GetMapping("/updateMemberForm")
   public String updateMemberForm() {
      return "/member/updateMemberForm";
   }
   
   @PutMapping("/members")
   public String updateMember(@ModelAttribute Member member) {
      memberService.updateMember(member);
      return "redirect:/member/members";
   }   
   
   @DeleteMapping("/members/{mid}")
   public String deleteMember(@PathVariable String mid) {
      memberService.deleteMember(mid);
      return "redirect:/member/members";
   }

} // class
