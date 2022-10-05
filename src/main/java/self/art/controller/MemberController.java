package self.art.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import self.art.dto.MemberDto;
import self.art.entity.Member;
import self.art.entity.RSA;
import self.art.service.MemberService;

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
		
		return "page/content";
	}
	
	@PostMapping(path="/loginProcessing")
	@ApiOperation(value = "로그인 진행")
	public String loginProcess(MemberDto memberDto,Model model,HttpServletRequest request) throws Exception {
		Member member =memberService.loginProcess(memberDto); 
		model.addAttribute("member", member);
		return "page/index";
	}
	
	@GetMapping(path = "/")
	@ApiOperation(value = "index 페이지")
	public String index(Model model) {
		return "page/content";
	}
}
