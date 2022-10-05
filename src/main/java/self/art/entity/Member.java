package self.art.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(schema = "self")
public class Member {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String memberId;
	
	private String memberPassword;
	
	private Date createDate;
	
	private Date updateDate;
}
