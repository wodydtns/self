package self.art.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import self.art.dto.MemberDto;
import self.art.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	List<MemberDto> findByMemberPassword(String memberPassword);

}
