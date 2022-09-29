package self.project.study.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import self.project.study.common.util.EncryptUtil;
import self.project.study.dto.MemberDto;
import self.project.study.entity.Member;
import self.project.study.repository.MemberJpaRepository;
import self.project.study.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberJpaRepository memberJpaRepository;

	@Override
	public Member login(MemberDto memberDto) {
		String memberPassword = memberDto.getMemberPassword();
		try {
			memberPassword = EncryptUtil.getSHA256Encrypt(memberPassword, "text");
			memberDto.setMemberPassword(memberPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberJpaRepository.login(memberDto);
	}
}
