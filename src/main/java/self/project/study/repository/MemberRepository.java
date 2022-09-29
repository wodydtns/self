package self.project.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import self.project.study.dto.MemberDto;
import self.project.study.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	List<MemberDto> findByMemberPassword(String memberPassword);

}
