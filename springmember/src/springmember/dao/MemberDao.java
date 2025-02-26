package springmember.dao;

import java.util.List;

import springmember.model.Member;

public interface MemberDao {

	public abstract List<Member> selectMember();
	public abstract Member getMember(String mid);
	public abstract int insertMember(Member member);
	public abstract int updateMember(Member member);
	public abstract int deleteMember(Member member);

}
