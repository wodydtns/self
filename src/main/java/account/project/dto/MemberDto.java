package account.project.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
	private String memberId;

	private String memberPassword;

	@QueryProjection
	public MemberDto(String memberId, String memberPassword) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
	}
}
