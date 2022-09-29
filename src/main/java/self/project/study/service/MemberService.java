package self.project.study.service;

import self.project.study.dto.MemberDto;
import self.project.study.entity.Member;

public interface MemberService {
	public Member login(MemberDto memberDto);
}
