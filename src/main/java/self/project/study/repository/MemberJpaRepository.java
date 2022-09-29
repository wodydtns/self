package self.project.study.repository;


import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.querydsl.jpa.impl.JPAQueryFactory;

import self.project.study.dto.MemberDto;
import self.project.study.entity.Member;

import static self.project.study.entity.QMember.member;

import javax.inject.Inject;

@Repository
public class MemberJpaRepository {
	
	@Inject
	private final JPAQueryFactory queryFactory;

	public MemberJpaRepository(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public  Member login(MemberDto memberDto) {
		if(StringUtils.hasText(memberDto.getMemberId()) && StringUtils.hasText(memberDto.getMemberPassword())) {
			return queryFactory.selectFrom(member).where(member.memberId.eq(memberDto.getMemberId()) , member.memberPassword.eq(memberDto.getMemberPassword())).fetchOne();
		}
		return null;
	}
}
