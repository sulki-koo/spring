package jdbcboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@GetMapping("/updateMemberForm/{mid}")
	public ModelAndView updateMemberForm(@PathVariable String mid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", memberService.getMember(mid));
		mav.setViewName("/member/updateMemberForm");
		return mav;
	}

	@PutMapping("/members")
	@ResponseBody
	public Map<String, Integer> updateMember(@RequestBody Member member) {
		int result = memberService.updateMember(member);
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("result", result);
		return resultMap;
	}

	@DeleteMapping("/members/{mid}")
	@ResponseBody
	public Map<String, Integer> deleteMember(@PathVariable String mid) {
		int result = memberService.deleteMember(mid);
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("result", result);
		return resultMap;
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Member member, HttpServletRequest request) {
		boolean result = memberService.checkLogin(member);
		if (result) {
			request.getSession().setAttribute("ss_mid", member.getMid());
		}
		return "redirect:/member/members";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null)
			session.invalidate();
		return "redirect:/member/members";
	}

} // class
