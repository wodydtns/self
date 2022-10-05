package self.art.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import self.art.dto.MemberDto;
import self.art.entity.Member;
import self.art.entity.RSA;

public interface MemberService {
	public Member loginProcess(MemberDto memberDto)  throws SQLException;
	
	public RSA login() throws NoSuchAlgorithmException, InvalidKeySpecException;
}
