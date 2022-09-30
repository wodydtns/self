package account.project.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import account.project.dto.MemberDto;
import account.project.entity.Member;
import account.project.entity.RSA;
import account.project.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@GetMapping(path = "/login")
	@ApiOperation(value = "로그인 페이지")
	public String login(HttpServletRequest request,Model model) throws SQLException{
		try {
			RSA rsa = memberService.login();
			model.addAttribute("rsa",rsa);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return "layout";
	}
	
	@PostMapping(path="/loginProcessing")
	@ApiOperation(value = "로그인 진행")
	public String loginProcess(MemberDto memberDto,Model model,HttpServletRequest request) throws Exception {
		Member member =memberService.loginProcess(memberDto); 
		model.addAttribute("member", member);
		return "layout";
	}
	
	@GetMapping(path = "/")
	@ApiOperation(value = "index 페이지")
	public String index(Model model) {
		return "layout";
	}
}