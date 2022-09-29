package self.project.study.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import self.project.study.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {

	@Inject
	private MemberService memberService;
	
	/*
	@GetMapping(path = "/login")
	public Member login(MemberDto memberDto) {
		return memberService.login(memberDto);
	}
	*/
	@GetMapping(path = "/")
	public String index(Model model) {
		return "layout";
	}
}
