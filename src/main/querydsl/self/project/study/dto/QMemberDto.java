package self.project.study.dto;

import com.querydsl.core.types.dsl.*;

import account.project.dto.MemberDto;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * self.project.study.dto.QMemberDto is a Querydsl Projection type for MemberDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberDto extends ConstructorExpression<MemberDto> {

    private static final long serialVersionUID = 59664922L;

    public QMemberDto(com.querydsl.core.types.Expression<String> memberId, com.querydsl.core.types.Expression<String> memberPassword) {
        super(MemberDto.class, new Class<?>[]{String.class, String.class}, memberId, memberPassword);
    }

}

