package me.hellonayeon.backend.member.dao;

import me.hellonayeon.backend.member.domain.Member;
import me.hellonayeon.backend.member.dto.param.CreateMemberParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao {

	Member findById(String id);

	Integer isExistUserId(String id);

	Integer createMember(CreateMemberParam param);
}
