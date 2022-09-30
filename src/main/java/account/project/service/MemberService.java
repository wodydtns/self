package account.project.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import account.project.dto.MemberDto;
import account.project.entity.Member;
import account.project.entity.RSA;

public interface MemberService {
	public Member loginProcess(MemberDto memberDto)  throws SQLException;
	
	public RSA login() throws NoSuchAlgorithmException, InvalidKeySpecException;
}
