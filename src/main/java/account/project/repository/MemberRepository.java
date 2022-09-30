package account.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import account.project.dto.MemberDto;
import account.project.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	List<MemberDto> findByMemberPassword(String memberPassword);

}
