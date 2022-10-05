package self.art.study.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import self.art.common.util.EncryptUtil;
import self.art.dto.MemberDto;
import self.art.entity.Member;
import self.art.entity.RSA;
import self.art.repository.MemberJpaRepository;
import self.art.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberJpaRepository memberJpaRepository;
	
	@Inject 
	private EncryptUtil encryptUtil;

	@Override
	public Member loginProcess(MemberDto memberDto) throws SQLException{
		String memberPassword = memberDto.getMemberPassword();
		try {
			memberPassword = encryptUtil.getSHA256Encrypt(memberPassword, "test");
			memberDto.setMemberPassword(memberPassword);;
		} catch (Exception e) {
			
		}
		return memberJpaRepository.login(memberDto);
	}

	@Override
	public RSA login() throws NoSuchAlgorithmException, InvalidKeySpecException {
		RSA rsa = new RSA();
		try {
			rsa  = encryptUtil.createRSAEncrypt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsa;
	}
}
